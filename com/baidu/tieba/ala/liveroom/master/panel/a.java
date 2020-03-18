package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ap;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private static final int fgL = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
    public static final int fgM = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds152);
    public static final int fgN = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
    private int[] fgO;
    private short[] fgP;
    private int[] fgQ;
    private InterfaceC0463a fgR;
    private View.OnClickListener fgS = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int qw = a.this.qw(itemId);
                if (qw >= 0) {
                    if (a.this.fgP[qw] == 1) {
                        a.this.fgP[qw] = 2;
                    } else if (a.this.fgP[qw] == 2) {
                        a.this.fgP[qw] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.fgP[qw] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.fgR != null) {
                a.this.fgR.z(i, z);
            }
        }
    };
    private Context mContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0463a {
        void z(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.fgO = new int[]{a.i.ala_operation_panel_text_mute, 0, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.fgQ = new int[]{4, 0, 5, 6};
            } else {
                this.fgO = new int[]{a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.fgQ = new int[]{4, 5, 6};
            }
            this.fgP = new short[]{1, 1, 1};
            return;
        }
        this.fgO = new int[]{a.i.ala_operation_panel_text_camera, a.i.ala_operation_panel_text_falshing, a.i.ala_operation_panel_text_mirror_off, a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
        this.fgP = new short[]{1, 1, 1, 1, 1, 1};
        this.fgQ = new int[]{1, 2, 3, 4, 5, 6};
        ap apVar = com.baidu.live.v.a.zs().axR;
        if (apVar != null && apVar.adg != null && apVar.adg.aeM) {
            int[] iArr = new int[this.fgO.length + 1];
            System.arraycopy(this.fgO, 0, iArr, 0, this.fgO.length);
            iArr[this.fgO.length] = a.i.ala_operation_panel_text_redpacket;
            this.fgO = iArr;
            short[] sArr = new short[this.fgP.length + 1];
            System.arraycopy(this.fgP, 0, sArr, 0, this.fgP.length);
            sArr[this.fgP.length] = 1;
            this.fgP = sArr;
            int[] iArr2 = new int[this.fgQ.length + 1];
            System.arraycopy(this.fgQ, 0, iArr2, 0, this.fgQ.length);
            iArr2[this.fgQ.length] = 7;
            this.fgQ = iArr2;
        }
        if (apVar != null && apVar.ada != null && apVar.ada.qP()) {
            int[] iArr3 = new int[this.fgO.length + 1];
            System.arraycopy(this.fgO, 0, iArr3, 0, this.fgO.length);
            iArr3[this.fgO.length] = a.i.ala_operation_panel_text_host_wish;
            this.fgO = iArr3;
            short[] sArr2 = new short[this.fgP.length + 1];
            System.arraycopy(this.fgP, 0, sArr2, 0, this.fgP.length);
            sArr2[this.fgP.length] = 1;
            this.fgP = sArr2;
            int[] iArr4 = new int[this.fgQ.length + 1];
            System.arraycopy(this.fgQ, 0, iArr4, 0, this.fgQ.length);
            iArr4[this.fgQ.length] = 8;
            this.fgQ = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fgQ.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.fgQ.length) {
            return -1L;
        }
        return this.fgQ[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return qs(this.fgQ[i]) ? 0 : 1;
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
        if (i < 0 || i >= this.fgQ.length) {
            return null;
        }
        int i2 = this.fgQ[i];
        int i3 = this.fgO[i];
        if (qs(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(getItemWidth(), boU()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, qt(i2), qu(i2));
            alaMasterOperationSwitchItemView2.h(this.fgP[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(getItemWidth(), boU()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, qv(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.fgS);
        return alaMasterOperationSwitchItemView;
    }

    private boolean qs(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int getItemWidth() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return fgL;
        }
        return -1;
    }

    private int boU() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? fgN : fgM;
    }

    private int qt(int i) {
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

    private int qu(int i) {
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

    private int qv(int i) {
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
    public int qw(int i) {
        for (int i2 = 0; i2 < this.fgQ.length; i2++) {
            if (this.fgQ[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int qw = qw(i);
        if (qw >= 0) {
            this.fgP[qw] = s;
        }
    }

    public void a(InterfaceC0463a interfaceC0463a) {
        this.fgR = interfaceC0463a;
    }
}
