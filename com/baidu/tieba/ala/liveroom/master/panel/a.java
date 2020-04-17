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
    private int[] fLa;
    private short[] fLb;
    private int[] fLc;
    private InterfaceC0498a fLd;
    private Context mContext;
    private final int fKX = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
    public final int fKY = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds152);
    public final int fKZ = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
    private View.OnClickListener fLe = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int qP = a.this.qP(itemId);
                if (qP >= 0) {
                    if (a.this.fLb[qP] == 1) {
                        a.this.fLb[qP] = 2;
                    } else if (a.this.fLb[qP] == 2) {
                        a.this.fLb[qP] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.fLb[qP] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.fLd != null) {
                a.this.fLd.C(i, z);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0498a {
        void C(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.fLa = new int[]{a.i.ala_operation_panel_text_mute, 0, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.fLc = new int[]{4, 0, 5, 6};
            } else {
                this.fLa = new int[]{a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.fLc = new int[]{4, 5, 6};
            }
            this.fLb = new short[]{1, 1, 1};
            return;
        }
        this.fLa = new int[]{a.i.ala_operation_panel_text_camera, a.i.ala_operation_panel_text_falshing, a.i.ala_operation_panel_text_mirror_off, a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
        this.fLb = new short[]{1, 1, 1, 1, 1, 1};
        this.fLc = new int[]{1, 2, 3, 4, 5, 6};
        as asVar = com.baidu.live.v.a.Eo().aRw;
        if (asVar != null && asVar.avx != null && asVar.avx.axc) {
            int[] iArr = new int[this.fLa.length + 1];
            System.arraycopy(this.fLa, 0, iArr, 0, this.fLa.length);
            iArr[this.fLa.length] = a.i.ala_operation_panel_text_redpacket;
            this.fLa = iArr;
            short[] sArr = new short[this.fLb.length + 1];
            System.arraycopy(this.fLb, 0, sArr, 0, this.fLb.length);
            sArr[this.fLb.length] = 1;
            this.fLb = sArr;
            int[] iArr2 = new int[this.fLc.length + 1];
            System.arraycopy(this.fLc, 0, iArr2, 0, this.fLc.length);
            iArr2[this.fLc.length] = 7;
            this.fLc = iArr2;
        }
        if (asVar != null && asVar.avs != null && asVar.avs.vg()) {
            int[] iArr3 = new int[this.fLa.length + 1];
            System.arraycopy(this.fLa, 0, iArr3, 0, this.fLa.length);
            iArr3[this.fLa.length] = a.i.ala_operation_panel_text_host_wish;
            this.fLa = iArr3;
            short[] sArr2 = new short[this.fLb.length + 1];
            System.arraycopy(this.fLb, 0, sArr2, 0, this.fLb.length);
            sArr2[this.fLb.length] = 1;
            this.fLb = sArr2;
            int[] iArr4 = new int[this.fLc.length + 1];
            System.arraycopy(this.fLc, 0, iArr4, 0, this.fLc.length);
            iArr4[this.fLc.length] = 8;
            this.fLc = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fLc.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.fLc.length) {
            return -1L;
        }
        return this.fLc[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return qL(this.fLc[i]) ? 0 : 1;
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
        if (i < 0 || i >= this.fLc.length) {
            return null;
        }
        int i2 = this.fLc[i];
        int i3 = this.fLa[i];
        if (qL(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(byn(), byo()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, qM(i2), qN(i2));
            alaMasterOperationSwitchItemView2.h(this.fLb[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(byn(), byo()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, qO(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.fLe);
        return alaMasterOperationSwitchItemView;
    }

    private boolean qL(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int byn() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return this.fKX;
        }
        return -1;
    }

    private int byo() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? this.fKZ : this.fKY;
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
        for (int i2 = 0; i2 < this.fLc.length; i2++) {
            if (this.fLc[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int qP = qP(i);
        if (qP >= 0) {
            this.fLb[qP] = s;
        }
    }

    public void a(InterfaceC0498a interfaceC0498a) {
        this.fLd = interfaceC0498a;
    }
}
