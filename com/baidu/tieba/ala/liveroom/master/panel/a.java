package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bq;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private int[] hEv;
    private short[] hEw;
    private int[] hEx;
    private InterfaceC0668a hEy;
    private Context mContext;
    private final int hEs = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds160);
    public final int hEt = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds152);
    public final int hEu = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) * 2)) / 4;
    private View.OnClickListener fjU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int vK = a.this.vK(itemId);
                if (vK >= 0) {
                    if (a.this.hEw[vK] == 1) {
                        a.this.hEw[vK] = 2;
                    } else if (a.this.hEw[vK] == 2) {
                        a.this.hEw[vK] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.hEw[vK] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.hEy != null) {
                a.this.hEy.L(i, z);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0668a {
        void L(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.hEv = new int[]{a.h.ala_operation_panel_text_mute, 0, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
                this.hEx = new int[]{4, 0, 5, 6};
            } else {
                this.hEv = new int[]{a.h.ala_operation_panel_text_mute, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
                this.hEx = new int[]{4, 5, 6};
            }
            this.hEw = new short[]{1, 1, 1};
            return;
        }
        this.hEv = new int[]{a.h.ala_operation_panel_text_camera, a.h.ala_operation_panel_text_falshing, a.h.ala_operation_panel_text_mirror_off, a.h.ala_operation_panel_text_mute, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
        this.hEw = new short[]{1, 1, 1, 1, 1, 1};
        this.hEx = new int[]{1, 2, 3, 4, 5, 6};
        bq bqVar = com.baidu.live.af.a.OJ().bxp;
        if (bqVar != null && bqVar.aMR != null && bqVar.aMR.aPv) {
            int[] iArr = new int[this.hEv.length + 1];
            System.arraycopy(this.hEv, 0, iArr, 0, this.hEv.length);
            iArr[this.hEv.length] = a.h.ala_operation_panel_text_redpacket;
            this.hEv = iArr;
            short[] sArr = new short[this.hEw.length + 1];
            System.arraycopy(this.hEw, 0, sArr, 0, this.hEw.length);
            sArr[this.hEw.length] = 1;
            this.hEw = sArr;
            int[] iArr2 = new int[this.hEx.length + 1];
            System.arraycopy(this.hEx, 0, iArr2, 0, this.hEx.length);
            iArr2[this.hEx.length] = 7;
            this.hEx = iArr2;
        }
        if (bqVar != null && bqVar.aMM != null && bqVar.aMM.Bo()) {
            int[] iArr3 = new int[this.hEv.length + 1];
            System.arraycopy(this.hEv, 0, iArr3, 0, this.hEv.length);
            iArr3[this.hEv.length] = a.h.ala_operation_panel_text_host_wish;
            this.hEv = iArr3;
            short[] sArr2 = new short[this.hEw.length + 1];
            System.arraycopy(this.hEw, 0, sArr2, 0, this.hEw.length);
            sArr2[this.hEw.length] = 1;
            this.hEw = sArr2;
            int[] iArr4 = new int[this.hEx.length + 1];
            System.arraycopy(this.hEx, 0, iArr4, 0, this.hEx.length);
            iArr4[this.hEx.length] = 8;
            this.hEx = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hEx.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.hEx.length) {
            return -1L;
        }
        return this.hEx[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return vG(this.hEx[i]) ? 0 : 1;
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
        if (i < 0 || i >= this.hEx.length) {
            return null;
        }
        int i2 = this.hEx[i];
        int i3 = this.hEv[i];
        if (vG(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(chE(), chF()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, vH(i2), vI(i2));
            alaMasterOperationSwitchItemView2.i(this.hEw[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(chE(), chF()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, vJ(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.fjU);
        return alaMasterOperationSwitchItemView;
    }

    private boolean vG(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int chE() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return this.hEs;
        }
        return -1;
    }

    private int chF() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? this.hEu : this.hEt;
    }

    private int vH(int i) {
        if (i == 1) {
            return a.e.btn_camera_exchange_white;
        }
        if (i == 2) {
            return a.e.btn_camera_light_switch_on;
        }
        if (i == 3) {
            return a.e.btn_camera_mirror;
        }
        if (i == 4) {
            return a.e.btn_audio_close;
        }
        return 0;
    }

    private int vI(int i) {
        if (i == 1) {
            return a.e.btn_camera_exchange_white;
        }
        if (i == 2) {
            return a.e.btn_camera_light_switch_off;
        }
        if (i == 3) {
            return a.e.btn_camera_mirror;
        }
        if (i == 4) {
            return a.e.btn_audio_open;
        }
        return 0;
    }

    private int vJ(int i) {
        if (i == 5) {
            return a.e.btn_live_admin;
        }
        if (i == 6) {
            return a.e.btn_live_blacklist;
        }
        if (i == 7) {
            return a.e.icon_live_redpacket;
        }
        if (i == 8) {
            return a.e.icon_live_anchor_wish;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int vK(int i) {
        for (int i2 = 0; i2 < this.hEx.length; i2++) {
            if (this.hEx[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int vK = vK(i);
        if (vK >= 0) {
            this.hEw[vK] = s;
        }
    }

    public void a(InterfaceC0668a interfaceC0668a) {
        this.hEy = interfaceC0668a;
    }
}
