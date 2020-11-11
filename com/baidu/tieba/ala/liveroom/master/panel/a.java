package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bn;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private int[] hnN;
    private short[] hnO;
    private int[] hnP;
    private InterfaceC0680a hnQ;
    private Context mContext;
    private final int hnK = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds160);
    public final int hnL = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds152);
    public final int hnM = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) * 2)) / 4;
    private View.OnClickListener eYr = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int wc = a.this.wc(itemId);
                if (wc >= 0) {
                    if (a.this.hnO[wc] == 1) {
                        a.this.hnO[wc] = 2;
                    } else if (a.this.hnO[wc] == 2) {
                        a.this.hnO[wc] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.hnO[wc] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.hnQ != null) {
                a.this.hnQ.L(i, z);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0680a {
        void L(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.hnN = new int[]{a.h.ala_operation_panel_text_mute, 0, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
                this.hnP = new int[]{4, 0, 5, 6};
            } else {
                this.hnN = new int[]{a.h.ala_operation_panel_text_mute, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
                this.hnP = new int[]{4, 5, 6};
            }
            this.hnO = new short[]{1, 1, 1};
            return;
        }
        this.hnN = new int[]{a.h.ala_operation_panel_text_camera, a.h.ala_operation_panel_text_falshing, a.h.ala_operation_panel_text_mirror_off, a.h.ala_operation_panel_text_mute, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
        this.hnO = new short[]{1, 1, 1, 1, 1, 1};
        this.hnP = new int[]{1, 2, 3, 4, 5, 6};
        bn bnVar = com.baidu.live.aa.a.PQ().btT;
        if (bnVar != null && bnVar.aPA != null && bnVar.aPA.aRT) {
            int[] iArr = new int[this.hnN.length + 1];
            System.arraycopy(this.hnN, 0, iArr, 0, this.hnN.length);
            iArr[this.hnN.length] = a.h.ala_operation_panel_text_redpacket;
            this.hnN = iArr;
            short[] sArr = new short[this.hnO.length + 1];
            System.arraycopy(this.hnO, 0, sArr, 0, this.hnO.length);
            sArr[this.hnO.length] = 1;
            this.hnO = sArr;
            int[] iArr2 = new int[this.hnP.length + 1];
            System.arraycopy(this.hnP, 0, iArr2, 0, this.hnP.length);
            iArr2[this.hnP.length] = 7;
            this.hnP = iArr2;
        }
        if (bnVar != null && bnVar.aPv != null && bnVar.aPv.ER()) {
            int[] iArr3 = new int[this.hnN.length + 1];
            System.arraycopy(this.hnN, 0, iArr3, 0, this.hnN.length);
            iArr3[this.hnN.length] = a.h.ala_operation_panel_text_host_wish;
            this.hnN = iArr3;
            short[] sArr2 = new short[this.hnO.length + 1];
            System.arraycopy(this.hnO, 0, sArr2, 0, this.hnO.length);
            sArr2[this.hnO.length] = 1;
            this.hnO = sArr2;
            int[] iArr4 = new int[this.hnP.length + 1];
            System.arraycopy(this.hnP, 0, iArr4, 0, this.hnP.length);
            iArr4[this.hnP.length] = 8;
            this.hnP = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hnP.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.hnP.length) {
            return -1L;
        }
        return this.hnP[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return vY(this.hnP[i]) ? 0 : 1;
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
        if (i < 0 || i >= this.hnP.length) {
            return null;
        }
        int i2 = this.hnP[i];
        int i3 = this.hnN[i];
        if (vY(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(cfr(), cfs()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, vZ(i2), wa(i2));
            alaMasterOperationSwitchItemView2.i(this.hnO[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(cfr(), cfs()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, wb(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.eYr);
        return alaMasterOperationSwitchItemView;
    }

    private boolean vY(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int cfr() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return this.hnK;
        }
        return -1;
    }

    private int cfs() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? this.hnM : this.hnL;
    }

    private int vZ(int i) {
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

    private int wa(int i) {
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

    private int wb(int i) {
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
    public int wc(int i) {
        for (int i2 = 0; i2 < this.hnP.length; i2++) {
            if (this.hnP[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int wc = wc(i);
        if (wc >= 0) {
            this.hnO[wc] = s;
        }
    }

    public void a(InterfaceC0680a interfaceC0680a) {
        this.hnQ = interfaceC0680a;
    }
}
