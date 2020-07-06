package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bb;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private int[] gmn;
    private short[] gmo;
    private int[] gmp;
    private InterfaceC0575a gmq;
    private Context mContext;
    private final int gmk = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
    public final int gml = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds152);
    public final int gmm = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
    private View.OnClickListener efJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int rQ = a.this.rQ(itemId);
                if (rQ >= 0) {
                    if (a.this.gmo[rQ] == 1) {
                        a.this.gmo[rQ] = 2;
                    } else if (a.this.gmo[rQ] == 2) {
                        a.this.gmo[rQ] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.gmo[rQ] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.gmq != null) {
                a.this.gmq.H(i, z);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0575a {
        void H(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.gmn = new int[]{a.i.ala_operation_panel_text_mute, 0, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.gmp = new int[]{4, 0, 5, 6};
            } else {
                this.gmn = new int[]{a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.gmp = new int[]{4, 5, 6};
            }
            this.gmo = new short[]{1, 1, 1};
            return;
        }
        this.gmn = new int[]{a.i.ala_operation_panel_text_camera, a.i.ala_operation_panel_text_falshing, a.i.ala_operation_panel_text_mirror_off, a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
        this.gmo = new short[]{1, 1, 1, 1, 1, 1};
        this.gmp = new int[]{1, 2, 3, 4, 5, 6};
        bb bbVar = com.baidu.live.v.a.Hm().bdV;
        if (bbVar != null && bbVar.aCW != null && bbVar.aCW.aEO) {
            int[] iArr = new int[this.gmn.length + 1];
            System.arraycopy(this.gmn, 0, iArr, 0, this.gmn.length);
            iArr[this.gmn.length] = a.i.ala_operation_panel_text_redpacket;
            this.gmn = iArr;
            short[] sArr = new short[this.gmo.length + 1];
            System.arraycopy(this.gmo, 0, sArr, 0, this.gmo.length);
            sArr[this.gmo.length] = 1;
            this.gmo = sArr;
            int[] iArr2 = new int[this.gmp.length + 1];
            System.arraycopy(this.gmp, 0, iArr2, 0, this.gmp.length);
            iArr2[this.gmp.length] = 7;
            this.gmp = iArr2;
        }
        if (bbVar != null && bbVar.aCR != null && bbVar.aCR.wS()) {
            int[] iArr3 = new int[this.gmn.length + 1];
            System.arraycopy(this.gmn, 0, iArr3, 0, this.gmn.length);
            iArr3[this.gmn.length] = a.i.ala_operation_panel_text_host_wish;
            this.gmn = iArr3;
            short[] sArr2 = new short[this.gmo.length + 1];
            System.arraycopy(this.gmo, 0, sArr2, 0, this.gmo.length);
            sArr2[this.gmo.length] = 1;
            this.gmo = sArr2;
            int[] iArr4 = new int[this.gmp.length + 1];
            System.arraycopy(this.gmp, 0, iArr4, 0, this.gmp.length);
            iArr4[this.gmp.length] = 8;
            this.gmp = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gmp.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.gmp.length) {
            return -1L;
        }
        return this.gmp[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return rM(this.gmp[i]) ? 0 : 1;
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
        if (i < 0 || i >= this.gmp.length) {
            return null;
        }
        int i2 = this.gmp[i];
        int i3 = this.gmn[i];
        if (rM(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(bHx(), bHy()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, rN(i2), rO(i2));
            alaMasterOperationSwitchItemView2.h(this.gmo[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(bHx(), bHy()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, rP(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.efJ);
        return alaMasterOperationSwitchItemView;
    }

    private boolean rM(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int bHx() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return this.gmk;
        }
        return -1;
    }

    private int bHy() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? this.gmm : this.gml;
    }

    private int rN(int i) {
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

    private int rO(int i) {
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

    private int rP(int i) {
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
    public int rQ(int i) {
        for (int i2 = 0; i2 < this.gmp.length; i2++) {
            if (this.gmp[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int rQ = rQ(i);
        if (rQ >= 0) {
            this.gmo[rQ] = s;
        }
    }

    public void a(InterfaceC0575a interfaceC0575a) {
        this.gmq = interfaceC0575a;
    }
}
