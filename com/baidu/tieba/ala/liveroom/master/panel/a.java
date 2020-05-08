package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.as;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private int[] fLf;
    private short[] fLg;
    private int[] fLh;
    private InterfaceC0519a fLi;
    private Context mContext;
    private final int fLc = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
    public final int fLd = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds152);
    public final int fLe = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
    private View.OnClickListener fLj = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int qP = a.this.qP(itemId);
                if (qP >= 0) {
                    if (a.this.fLg[qP] == 1) {
                        a.this.fLg[qP] = 2;
                    } else if (a.this.fLg[qP] == 2) {
                        a.this.fLg[qP] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.fLg[qP] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.fLi != null) {
                a.this.fLi.C(i, z);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0519a {
        void C(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.fLf = new int[]{a.i.ala_operation_panel_text_mute, 0, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.fLh = new int[]{4, 0, 5, 6};
            } else {
                this.fLf = new int[]{a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.fLh = new int[]{4, 5, 6};
            }
            this.fLg = new short[]{1, 1, 1};
            return;
        }
        this.fLf = new int[]{a.i.ala_operation_panel_text_camera, a.i.ala_operation_panel_text_falshing, a.i.ala_operation_panel_text_mirror_off, a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
        this.fLg = new short[]{1, 1, 1, 1, 1, 1};
        this.fLh = new int[]{1, 2, 3, 4, 5, 6};
        as asVar = com.baidu.live.v.a.En().aRB;
        if (asVar != null && asVar.avD != null && asVar.avD.axi) {
            int[] iArr = new int[this.fLf.length + 1];
            System.arraycopy(this.fLf, 0, iArr, 0, this.fLf.length);
            iArr[this.fLf.length] = a.i.ala_operation_panel_text_redpacket;
            this.fLf = iArr;
            short[] sArr = new short[this.fLg.length + 1];
            System.arraycopy(this.fLg, 0, sArr, 0, this.fLg.length);
            sArr[this.fLg.length] = 1;
            this.fLg = sArr;
            int[] iArr2 = new int[this.fLh.length + 1];
            System.arraycopy(this.fLh, 0, iArr2, 0, this.fLh.length);
            iArr2[this.fLh.length] = 7;
            this.fLh = iArr2;
        }
        if (asVar != null && asVar.avy != null && asVar.avy.vf()) {
            int[] iArr3 = new int[this.fLf.length + 1];
            System.arraycopy(this.fLf, 0, iArr3, 0, this.fLf.length);
            iArr3[this.fLf.length] = a.i.ala_operation_panel_text_host_wish;
            this.fLf = iArr3;
            short[] sArr2 = new short[this.fLg.length + 1];
            System.arraycopy(this.fLg, 0, sArr2, 0, this.fLg.length);
            sArr2[this.fLg.length] = 1;
            this.fLg = sArr2;
            int[] iArr4 = new int[this.fLh.length + 1];
            System.arraycopy(this.fLh, 0, iArr4, 0, this.fLh.length);
            iArr4[this.fLh.length] = 8;
            this.fLh = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fLh.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.fLh.length) {
            return -1L;
        }
        return this.fLh[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return qL(this.fLh[i]) ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return e(i, view);
    }

    private AlaMasterOperationBaseItemView e(int i, View view) {
        AlaMasterOperationEntryItemView alaMasterOperationEntryItemView;
        AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView;
        AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView2;
        if (i < 0 || i >= this.fLh.length) {
            return null;
        }
        int i2 = this.fLh[i];
        int i3 = this.fLf[i];
        if (qL(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(byl(), bym()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, qM(i2), qN(i2));
            alaMasterOperationSwitchItemView2.h(this.fLg[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(byl(), bym()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, qO(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.fLj);
        return alaMasterOperationSwitchItemView;
    }

    private boolean qL(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int byl() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return this.fLc;
        }
        return -1;
    }

    private int bym() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? this.fLe : this.fLd;
    }

    private int qM(int i) {
        if (i == 1) {
            return a.f.btn_camera_exchange_white;
        }
        if (i == 2) {
            return a.f.btn_camera_light_switch_on;
        }
        if (i == 3) {
            return a.f.btn_camera_mirror;
        }
        if (i == 4) {
            return a.f.btn_audio_close;
        }
        return 0;
    }

    private int qN(int i) {
        if (i == 1) {
            return a.f.btn_camera_exchange_white;
        }
        if (i == 2) {
            return a.f.btn_camera_light_switch_off;
        }
        if (i == 3) {
            return a.f.btn_camera_mirror;
        }
        if (i == 4) {
            return a.f.btn_audio_open;
        }
        return 0;
    }

    private int qO(int i) {
        if (i == 5) {
            return a.f.btn_live_admin;
        }
        if (i == 6) {
            return a.f.btn_live_blacklist;
        }
        if (i == 7) {
            return a.f.icon_live_redpacket;
        }
        if (i == 8) {
            return a.f.icon_live_anchor_wish;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int qP(int i) {
        for (int i2 = 0; i2 < this.fLh.length; i2++) {
            if (this.fLh[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int qP = qP(i);
        if (qP >= 0) {
            this.fLg[qP] = s;
        }
    }

    public void a(InterfaceC0519a interfaceC0519a) {
        this.fLi = interfaceC0519a;
    }
}
