package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bc;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private int[] grl;
    private short[] grm;
    private int[] grn;
    private InterfaceC0585a gro;
    private Context mContext;
    private final int gri = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
    public final int grj = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds152);
    public final int grk = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
    private View.OnClickListener elT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int sh = a.this.sh(itemId);
                if (sh >= 0) {
                    if (a.this.grm[sh] == 1) {
                        a.this.grm[sh] = 2;
                    } else if (a.this.grm[sh] == 2) {
                        a.this.grm[sh] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.grm[sh] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.gro != null) {
                a.this.gro.H(i, z);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0585a {
        void H(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.grl = new int[]{a.i.ala_operation_panel_text_mute, 0, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.grn = new int[]{4, 0, 5, 6};
            } else {
                this.grl = new int[]{a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.grn = new int[]{4, 5, 6};
            }
            this.grm = new short[]{1, 1, 1};
            return;
        }
        this.grl = new int[]{a.i.ala_operation_panel_text_camera, a.i.ala_operation_panel_text_falshing, a.i.ala_operation_panel_text_mirror_off, a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
        this.grm = new short[]{1, 1, 1, 1, 1, 1};
        this.grn = new int[]{1, 2, 3, 4, 5, 6};
        bc bcVar = com.baidu.live.v.a.Hs().beo;
        if (bcVar != null && bcVar.aEr != null && bcVar.aEr.aGi) {
            int[] iArr = new int[this.grl.length + 1];
            System.arraycopy(this.grl, 0, iArr, 0, this.grl.length);
            iArr[this.grl.length] = a.i.ala_operation_panel_text_redpacket;
            this.grl = iArr;
            short[] sArr = new short[this.grm.length + 1];
            System.arraycopy(this.grm, 0, sArr, 0, this.grm.length);
            sArr[this.grm.length] = 1;
            this.grm = sArr;
            int[] iArr2 = new int[this.grn.length + 1];
            System.arraycopy(this.grn, 0, iArr2, 0, this.grn.length);
            iArr2[this.grn.length] = 7;
            this.grn = iArr2;
        }
        if (bcVar != null && bcVar.aEm != null && bcVar.aEm.xv()) {
            int[] iArr3 = new int[this.grl.length + 1];
            System.arraycopy(this.grl, 0, iArr3, 0, this.grl.length);
            iArr3[this.grl.length] = a.i.ala_operation_panel_text_host_wish;
            this.grl = iArr3;
            short[] sArr2 = new short[this.grm.length + 1];
            System.arraycopy(this.grm, 0, sArr2, 0, this.grm.length);
            sArr2[this.grm.length] = 1;
            this.grm = sArr2;
            int[] iArr4 = new int[this.grn.length + 1];
            System.arraycopy(this.grn, 0, iArr4, 0, this.grn.length);
            iArr4[this.grn.length] = 8;
            this.grn = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.grn.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.grn.length) {
            return -1L;
        }
        return this.grn[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return sd(this.grn[i]) ? 0 : 1;
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
        if (i < 0 || i >= this.grn.length) {
            return null;
        }
        int i2 = this.grn[i];
        int i3 = this.grl[i];
        if (sd(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(bKD(), bKE()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, se(i2), sf(i2));
            alaMasterOperationSwitchItemView2.h(this.grm[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(bKD(), bKE()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, sg(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.elT);
        return alaMasterOperationSwitchItemView;
    }

    private boolean sd(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int bKD() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return this.gri;
        }
        return -1;
    }

    private int bKE() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? this.grk : this.grj;
    }

    private int se(int i) {
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

    private int sf(int i) {
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

    private int sg(int i) {
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
    public int sh(int i) {
        for (int i2 = 0; i2 < this.grn.length; i2++) {
            if (this.grn[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int sh = sh(i);
        if (sh >= 0) {
            this.grm[sh] = s;
        }
    }

    public void a(InterfaceC0585a interfaceC0585a) {
        this.gro = interfaceC0585a;
    }
}
