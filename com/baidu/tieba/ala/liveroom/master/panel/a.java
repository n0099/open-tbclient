package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.be;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private int[] gEj;
    private short[] gEk;
    private int[] gEl;
    private InterfaceC0635a gEm;
    private Context mContext;
    private final int gEg = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
    public final int gEh = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds152);
    public final int gEi = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
    private View.OnClickListener evS = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int ux = a.this.ux(itemId);
                if (ux >= 0) {
                    if (a.this.gEk[ux] == 1) {
                        a.this.gEk[ux] = 2;
                    } else if (a.this.gEk[ux] == 2) {
                        a.this.gEk[ux] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.gEk[ux] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.gEm != null) {
                a.this.gEm.J(i, z);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0635a {
        void J(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.gEj = new int[]{a.i.ala_operation_panel_text_mute, 0, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.gEl = new int[]{4, 0, 5, 6};
            } else {
                this.gEj = new int[]{a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.gEl = new int[]{4, 5, 6};
            }
            this.gEk = new short[]{1, 1, 1};
            return;
        }
        this.gEj = new int[]{a.i.ala_operation_panel_text_camera, a.i.ala_operation_panel_text_falshing, a.i.ala_operation_panel_text_mirror_off, a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
        this.gEk = new short[]{1, 1, 1, 1, 1, 1};
        this.gEl = new int[]{1, 2, 3, 4, 5, 6};
        be beVar = com.baidu.live.w.a.Nk().bkd;
        if (beVar != null && beVar.aJD != null && beVar.aJD.aLu) {
            int[] iArr = new int[this.gEj.length + 1];
            System.arraycopy(this.gEj, 0, iArr, 0, this.gEj.length);
            iArr[this.gEj.length] = a.i.ala_operation_panel_text_redpacket;
            this.gEj = iArr;
            short[] sArr = new short[this.gEk.length + 1];
            System.arraycopy(this.gEk, 0, sArr, 0, this.gEk.length);
            sArr[this.gEk.length] = 1;
            this.gEk = sArr;
            int[] iArr2 = new int[this.gEl.length + 1];
            System.arraycopy(this.gEl, 0, iArr2, 0, this.gEl.length);
            iArr2[this.gEl.length] = 7;
            this.gEl = iArr2;
        }
        if (beVar != null && beVar.aJy != null && beVar.aJy.CY()) {
            int[] iArr3 = new int[this.gEj.length + 1];
            System.arraycopy(this.gEj, 0, iArr3, 0, this.gEj.length);
            iArr3[this.gEj.length] = a.i.ala_operation_panel_text_host_wish;
            this.gEj = iArr3;
            short[] sArr2 = new short[this.gEk.length + 1];
            System.arraycopy(this.gEk, 0, sArr2, 0, this.gEk.length);
            sArr2[this.gEk.length] = 1;
            this.gEk = sArr2;
            int[] iArr4 = new int[this.gEl.length + 1];
            System.arraycopy(this.gEl, 0, iArr4, 0, this.gEl.length);
            iArr4[this.gEl.length] = 8;
            this.gEl = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gEl.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.gEl.length) {
            return -1L;
        }
        return this.gEl[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ut(this.gEl[i]) ? 0 : 1;
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
        if (i < 0 || i >= this.gEl.length) {
            return null;
        }
        int i2 = this.gEl[i];
        int i3 = this.gEj[i];
        if (ut(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(bUH(), bUI()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, uu(i2), uv(i2));
            alaMasterOperationSwitchItemView2.h(this.gEk[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(bUH(), bUI()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, uw(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.evS);
        return alaMasterOperationSwitchItemView;
    }

    private boolean ut(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int bUH() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return this.gEg;
        }
        return -1;
    }

    private int bUI() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? this.gEi : this.gEh;
    }

    private int uu(int i) {
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

    private int uv(int i) {
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

    private int uw(int i) {
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
    public int ux(int i) {
        for (int i2 = 0; i2 < this.gEl.length; i2++) {
            if (this.gEl[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int ux = ux(i);
        if (ux >= 0) {
            this.gEk[ux] = s;
        }
    }

    public void a(InterfaceC0635a interfaceC0635a) {
        this.gEm = interfaceC0635a;
    }
}
