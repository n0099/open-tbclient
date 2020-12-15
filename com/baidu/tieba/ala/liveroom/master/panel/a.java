package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bo;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private int[] hxd;
    private short[] hxe;
    private int[] hxf;
    private InterfaceC0693a hxg;
    private Context mContext;
    private final int hxa = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds160);
    public final int hxb = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds152);
    public final int hxc = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) * 2)) / 4;
    private View.OnClickListener feV = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int xf = a.this.xf(itemId);
                if (xf >= 0) {
                    if (a.this.hxe[xf] == 1) {
                        a.this.hxe[xf] = 2;
                    } else if (a.this.hxe[xf] == 2) {
                        a.this.hxe[xf] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.hxe[xf] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.hxg != null) {
                a.this.hxg.L(i, z);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0693a {
        void L(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.hxd = new int[]{a.h.ala_operation_panel_text_mute, 0, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
                this.hxf = new int[]{4, 0, 5, 6};
            } else {
                this.hxd = new int[]{a.h.ala_operation_panel_text_mute, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
                this.hxf = new int[]{4, 5, 6};
            }
            this.hxe = new short[]{1, 1, 1};
            return;
        }
        this.hxd = new int[]{a.h.ala_operation_panel_text_camera, a.h.ala_operation_panel_text_falshing, a.h.ala_operation_panel_text_mirror_off, a.h.ala_operation_panel_text_mute, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
        this.hxe = new short[]{1, 1, 1, 1, 1, 1};
        this.hxf = new int[]{1, 2, 3, 4, 5, 6};
        bo boVar = com.baidu.live.ae.a.RB().bxq;
        if (boVar != null && boVar.aQP != null && boVar.aQP.aTk) {
            int[] iArr = new int[this.hxd.length + 1];
            System.arraycopy(this.hxd, 0, iArr, 0, this.hxd.length);
            iArr[this.hxd.length] = a.h.ala_operation_panel_text_redpacket;
            this.hxd = iArr;
            short[] sArr = new short[this.hxe.length + 1];
            System.arraycopy(this.hxe, 0, sArr, 0, this.hxe.length);
            sArr[this.hxe.length] = 1;
            this.hxe = sArr;
            int[] iArr2 = new int[this.hxf.length + 1];
            System.arraycopy(this.hxf, 0, iArr2, 0, this.hxf.length);
            iArr2[this.hxf.length] = 7;
            this.hxf = iArr2;
        }
        if (boVar != null && boVar.aQK != null && boVar.aQK.FT()) {
            int[] iArr3 = new int[this.hxd.length + 1];
            System.arraycopy(this.hxd, 0, iArr3, 0, this.hxd.length);
            iArr3[this.hxd.length] = a.h.ala_operation_panel_text_host_wish;
            this.hxd = iArr3;
            short[] sArr2 = new short[this.hxe.length + 1];
            System.arraycopy(this.hxe, 0, sArr2, 0, this.hxe.length);
            sArr2[this.hxe.length] = 1;
            this.hxe = sArr2;
            int[] iArr4 = new int[this.hxf.length + 1];
            System.arraycopy(this.hxf, 0, iArr4, 0, this.hxf.length);
            iArr4[this.hxf.length] = 8;
            this.hxf = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hxf.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.hxf.length) {
            return -1L;
        }
        return this.hxf[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return xb(this.hxf[i]) ? 0 : 1;
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
        if (i < 0 || i >= this.hxf.length) {
            return null;
        }
        int i2 = this.hxf[i];
        int i3 = this.hxd[i];
        if (xb(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(ciH(), ciI()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, xc(i2), xd(i2));
            alaMasterOperationSwitchItemView2.i(this.hxe[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(ciH(), ciI()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, xe(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.feV);
        return alaMasterOperationSwitchItemView;
    }

    private boolean xb(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int ciH() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return this.hxa;
        }
        return -1;
    }

    private int ciI() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? this.hxc : this.hxb;
    }

    private int xc(int i) {
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

    private int xd(int i) {
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

    private int xe(int i) {
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
    public int xf(int i) {
        for (int i2 = 0; i2 < this.hxf.length; i2++) {
            if (this.hxf[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int xf = xf(i);
        if (xf >= 0) {
            this.hxe[xf] = s;
        }
    }

    public void a(InterfaceC0693a interfaceC0693a) {
        this.hxg = interfaceC0693a;
    }
}
