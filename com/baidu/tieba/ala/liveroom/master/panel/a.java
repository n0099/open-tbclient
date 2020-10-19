package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bj;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private int[] gWg;
    private short[] gWh;
    private int[] gWi;
    private InterfaceC0650a gWj;
    private Context mContext;
    private final int gWd = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
    public final int gWe = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds152);
    public final int gWf = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
    private View.OnClickListener eKg = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int vv = a.this.vv(itemId);
                if (vv >= 0) {
                    if (a.this.gWh[vv] == 1) {
                        a.this.gWh[vv] = 2;
                    } else if (a.this.gWh[vv] == 2) {
                        a.this.gWh[vv] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.gWh[vv] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.gWj != null) {
                a.this.gWj.L(i, z);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0650a {
        void L(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.gWg = new int[]{a.i.ala_operation_panel_text_mute, 0, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.gWi = new int[]{4, 0, 5, 6};
            } else {
                this.gWg = new int[]{a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.gWi = new int[]{4, 5, 6};
            }
            this.gWh = new short[]{1, 1, 1};
            return;
        }
        this.gWg = new int[]{a.i.ala_operation_panel_text_camera, a.i.ala_operation_panel_text_falshing, a.i.ala_operation_panel_text_mirror_off, a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
        this.gWh = new short[]{1, 1, 1, 1, 1, 1};
        this.gWi = new int[]{1, 2, 3, 4, 5, 6};
        bj bjVar = com.baidu.live.x.a.OS().bqJ;
        if (bjVar != null && bjVar.aNY != null && bjVar.aNY.aQh) {
            int[] iArr = new int[this.gWg.length + 1];
            System.arraycopy(this.gWg, 0, iArr, 0, this.gWg.length);
            iArr[this.gWg.length] = a.i.ala_operation_panel_text_redpacket;
            this.gWg = iArr;
            short[] sArr = new short[this.gWh.length + 1];
            System.arraycopy(this.gWh, 0, sArr, 0, this.gWh.length);
            sArr[this.gWh.length] = 1;
            this.gWh = sArr;
            int[] iArr2 = new int[this.gWi.length + 1];
            System.arraycopy(this.gWi, 0, iArr2, 0, this.gWi.length);
            iArr2[this.gWi.length] = 7;
            this.gWi = iArr2;
        }
        if (bjVar != null && bjVar.aNT != null && bjVar.aNT.El()) {
            int[] iArr3 = new int[this.gWg.length + 1];
            System.arraycopy(this.gWg, 0, iArr3, 0, this.gWg.length);
            iArr3[this.gWg.length] = a.i.ala_operation_panel_text_host_wish;
            this.gWg = iArr3;
            short[] sArr2 = new short[this.gWh.length + 1];
            System.arraycopy(this.gWh, 0, sArr2, 0, this.gWh.length);
            sArr2[this.gWh.length] = 1;
            this.gWh = sArr2;
            int[] iArr4 = new int[this.gWi.length + 1];
            System.arraycopy(this.gWi, 0, iArr4, 0, this.gWi.length);
            iArr4[this.gWi.length] = 8;
            this.gWi = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gWi.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.gWi.length) {
            return -1L;
        }
        return this.gWi[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return vr(this.gWi[i]) ? 0 : 1;
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
        if (i < 0 || i >= this.gWi.length) {
            return null;
        }
        int i2 = this.gWi[i];
        int i3 = this.gWg[i];
        if (vr(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(bZM(), bZN()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, vs(i2), vt(i2));
            alaMasterOperationSwitchItemView2.h(this.gWh[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(bZM(), bZN()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, vu(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.eKg);
        return alaMasterOperationSwitchItemView;
    }

    private boolean vr(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int bZM() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return this.gWd;
        }
        return -1;
    }

    private int bZN() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? this.gWf : this.gWe;
    }

    private int vs(int i) {
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

    private int vt(int i) {
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

    private int vu(int i) {
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
    public int vv(int i) {
        for (int i2 = 0; i2 < this.gWi.length; i2++) {
            if (this.gWi[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int vv = vv(i);
        if (vv >= 0) {
            this.gWh[vv] = s;
        }
    }

    public void a(InterfaceC0650a interfaceC0650a) {
        this.gWj = interfaceC0650a;
    }
}
