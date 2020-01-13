package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ao;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private static final int fcP = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
    public static final int fcQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds152);
    public static final int fcR = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
    private int[] fcS;
    private short[] fcT;
    private int[] fcU;
    private InterfaceC0453a fcV;
    private View.OnClickListener fcW = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int qn = a.this.qn(itemId);
                if (qn >= 0) {
                    if (a.this.fcT[qn] == 1) {
                        a.this.fcT[qn] = 2;
                    } else if (a.this.fcT[qn] == 2) {
                        a.this.fcT[qn] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.fcT[qn] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.fcV != null) {
                a.this.fcV.A(i, z);
            }
        }
    };
    private Context mContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0453a {
        void A(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.fcS = new int[]{a.i.ala_operation_panel_text_mute, 0, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.fcU = new int[]{4, 0, 5, 6};
            } else {
                this.fcS = new int[]{a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.fcU = new int[]{4, 5, 6};
            }
            this.fcT = new short[]{1, 1, 1};
            return;
        }
        this.fcS = new int[]{a.i.ala_operation_panel_text_camera, a.i.ala_operation_panel_text_falshing, a.i.ala_operation_panel_text_mirror_off, a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
        this.fcT = new short[]{1, 1, 1, 1, 1, 1};
        this.fcU = new int[]{1, 2, 3, 4, 5, 6};
        ao aoVar = com.baidu.live.s.a.wR().atk;
        if (aoVar != null && aoVar.aaX != null && aoVar.aaX.acB) {
            int[] iArr = new int[this.fcS.length + 1];
            System.arraycopy(this.fcS, 0, iArr, 0, this.fcS.length);
            iArr[this.fcS.length] = a.i.ala_operation_panel_text_redpacket;
            this.fcS = iArr;
            short[] sArr = new short[this.fcT.length + 1];
            System.arraycopy(this.fcT, 0, sArr, 0, this.fcT.length);
            sArr[this.fcT.length] = 1;
            this.fcT = sArr;
            int[] iArr2 = new int[this.fcU.length + 1];
            System.arraycopy(this.fcU, 0, iArr2, 0, this.fcU.length);
            iArr2[this.fcU.length] = 7;
            this.fcU = iArr2;
        }
        if (aoVar != null && aoVar.aaS != null && aoVar.aaS.pZ()) {
            int[] iArr3 = new int[this.fcS.length + 1];
            System.arraycopy(this.fcS, 0, iArr3, 0, this.fcS.length);
            iArr3[this.fcS.length] = a.i.ala_operation_panel_text_host_wish;
            this.fcS = iArr3;
            short[] sArr2 = new short[this.fcT.length + 1];
            System.arraycopy(this.fcT, 0, sArr2, 0, this.fcT.length);
            sArr2[this.fcT.length] = 1;
            this.fcT = sArr2;
            int[] iArr4 = new int[this.fcU.length + 1];
            System.arraycopy(this.fcU, 0, iArr4, 0, this.fcU.length);
            iArr4[this.fcU.length] = 8;
            this.fcU = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fcU.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.fcU.length) {
            return -1L;
        }
        return this.fcU[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return qj(this.fcU[i]) ? 0 : 1;
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
        if (i < 0 || i >= this.fcU.length) {
            return null;
        }
        int i2 = this.fcU[i];
        int i3 = this.fcS[i];
        if (qj(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(getItemWidth(), bnc()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, qk(i2), ql(i2));
            alaMasterOperationSwitchItemView2.f(this.fcT[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(getItemWidth(), bnc()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, qm(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.fcW);
        return alaMasterOperationSwitchItemView;
    }

    private boolean qj(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int getItemWidth() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return fcP;
        }
        return -1;
    }

    private int bnc() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? fcR : fcQ;
    }

    private int qk(int i) {
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

    private int ql(int i) {
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

    private int qm(int i) {
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
    public int qn(int i) {
        for (int i2 = 0; i2 < this.fcU.length; i2++) {
            if (this.fcU[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int qn = qn(i);
        if (qn >= 0) {
            this.fcT[qn] = s;
        }
    }

    public void a(InterfaceC0453a interfaceC0453a) {
        this.fcV = interfaceC0453a;
    }
}
