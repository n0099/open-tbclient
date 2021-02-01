package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bv;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private int[] hIH;
    private short[] hII;
    private int[] hIJ;
    private InterfaceC0669a hIK;
    private Context mContext;
    private final int hIE = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds160);
    public final int hIF = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds152);
    public final int hIG = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) * 2)) / 4;
    private View.OnClickListener fml = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int vV = a.this.vV(itemId);
                if (vV >= 0) {
                    if (a.this.hII[vV] == 1) {
                        a.this.hII[vV] = 2;
                    } else if (a.this.hII[vV] == 2) {
                        a.this.hII[vV] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.hII[vV] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.hIK != null) {
                a.this.hIK.L(i, z);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0669a {
        void L(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.hIH = new int[]{a.h.ala_operation_panel_text_mute, 0, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
                this.hIJ = new int[]{4, 0, 5, 6};
            } else {
                this.hIH = new int[]{a.h.ala_operation_panel_text_mute, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
                this.hIJ = new int[]{4, 5, 6};
            }
            this.hII = new short[]{1, 1, 1};
            return;
        }
        this.hIH = new int[]{a.h.ala_operation_panel_text_camera, a.h.ala_operation_panel_text_falshing, a.h.ala_operation_panel_text_mirror_off, a.h.ala_operation_panel_text_mute, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
        this.hII = new short[]{1, 1, 1, 1, 1, 1};
        this.hIJ = new int[]{1, 2, 3, 4, 5, 6};
        bv bvVar = com.baidu.live.ae.a.Qj().bAS;
        if (bvVar != null && bvVar.aPP != null && bvVar.aPP.aSx) {
            int[] iArr = new int[this.hIH.length + 1];
            System.arraycopy(this.hIH, 0, iArr, 0, this.hIH.length);
            iArr[this.hIH.length] = a.h.ala_operation_panel_text_redpacket;
            this.hIH = iArr;
            short[] sArr = new short[this.hII.length + 1];
            System.arraycopy(this.hII, 0, sArr, 0, this.hII.length);
            sArr[this.hII.length] = 1;
            this.hII = sArr;
            int[] iArr2 = new int[this.hIJ.length + 1];
            System.arraycopy(this.hIJ, 0, iArr2, 0, this.hIJ.length);
            iArr2[this.hIJ.length] = 7;
            this.hIJ = iArr2;
        }
        if (bvVar != null && bvVar.aPK != null && bvVar.aPK.CB()) {
            int[] iArr3 = new int[this.hIH.length + 1];
            System.arraycopy(this.hIH, 0, iArr3, 0, this.hIH.length);
            iArr3[this.hIH.length] = a.h.ala_operation_panel_text_host_wish;
            this.hIH = iArr3;
            short[] sArr2 = new short[this.hII.length + 1];
            System.arraycopy(this.hII, 0, sArr2, 0, this.hII.length);
            sArr2[this.hII.length] = 1;
            this.hII = sArr2;
            int[] iArr4 = new int[this.hIJ.length + 1];
            System.arraycopy(this.hIJ, 0, iArr4, 0, this.hIJ.length);
            iArr4[this.hIJ.length] = 8;
            this.hIJ = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hIJ.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.hIJ.length) {
            return -1L;
        }
        return this.hIJ[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return vR(this.hIJ[i]) ? 0 : 1;
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
        if (i < 0 || i >= this.hIJ.length) {
            return null;
        }
        int i2 = this.hIJ[i];
        int i3 = this.hIH[i];
        if (vR(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(cix(), ciy()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, vS(i2), vT(i2));
            alaMasterOperationSwitchItemView2.i(this.hII[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(cix(), ciy()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, vU(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.fml);
        return alaMasterOperationSwitchItemView;
    }

    private boolean vR(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int cix() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return this.hIE;
        }
        return -1;
    }

    private int ciy() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? this.hIG : this.hIF;
    }

    private int vS(int i) {
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

    private int vT(int i) {
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

    private int vU(int i) {
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
    public int vV(int i) {
        for (int i2 = 0; i2 < this.hIJ.length; i2++) {
            if (this.hIJ[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int vV = vV(i);
        if (vV >= 0) {
            this.hII[vV] = s;
        }
    }

    public void a(InterfaceC0669a interfaceC0669a) {
        this.hIK = interfaceC0669a;
    }
}
