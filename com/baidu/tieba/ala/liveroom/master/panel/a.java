package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ax;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private int[] fZd;
    private short[] fZe;
    private int[] fZf;
    private InterfaceC0566a fZg;
    private Context mContext;
    private final int fZa = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
    public final int fZb = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds152);
    public final int fZc = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
    private View.OnClickListener fZh = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int rq = a.this.rq(itemId);
                if (rq >= 0) {
                    if (a.this.fZe[rq] == 1) {
                        a.this.fZe[rq] = 2;
                    } else if (a.this.fZe[rq] == 2) {
                        a.this.fZe[rq] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.fZe[rq] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.fZg != null) {
                a.this.fZg.F(i, z);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0566a {
        void F(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.fZd = new int[]{a.i.ala_operation_panel_text_mute, 0, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.fZf = new int[]{4, 0, 5, 6};
            } else {
                this.fZd = new int[]{a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.fZf = new int[]{4, 5, 6};
            }
            this.fZe = new short[]{1, 1, 1};
            return;
        }
        this.fZd = new int[]{a.i.ala_operation_panel_text_camera, a.i.ala_operation_panel_text_falshing, a.i.ala_operation_panel_text_mirror_off, a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
        this.fZe = new short[]{1, 1, 1, 1, 1, 1};
        this.fZf = new int[]{1, 2, 3, 4, 5, 6};
        ax axVar = com.baidu.live.v.a.Ge().aYP;
        if (axVar != null && axVar.aAL != null && axVar.aAL.aCx) {
            int[] iArr = new int[this.fZd.length + 1];
            System.arraycopy(this.fZd, 0, iArr, 0, this.fZd.length);
            iArr[this.fZd.length] = a.i.ala_operation_panel_text_redpacket;
            this.fZd = iArr;
            short[] sArr = new short[this.fZe.length + 1];
            System.arraycopy(this.fZe, 0, sArr, 0, this.fZe.length);
            sArr[this.fZe.length] = 1;
            this.fZe = sArr;
            int[] iArr2 = new int[this.fZf.length + 1];
            System.arraycopy(this.fZf, 0, iArr2, 0, this.fZf.length);
            iArr2[this.fZf.length] = 7;
            this.fZf = iArr2;
        }
        if (axVar != null && axVar.aAG != null && axVar.aAG.wu()) {
            int[] iArr3 = new int[this.fZd.length + 1];
            System.arraycopy(this.fZd, 0, iArr3, 0, this.fZd.length);
            iArr3[this.fZd.length] = a.i.ala_operation_panel_text_host_wish;
            this.fZd = iArr3;
            short[] sArr2 = new short[this.fZe.length + 1];
            System.arraycopy(this.fZe, 0, sArr2, 0, this.fZe.length);
            sArr2[this.fZe.length] = 1;
            this.fZe = sArr2;
            int[] iArr4 = new int[this.fZf.length + 1];
            System.arraycopy(this.fZf, 0, iArr4, 0, this.fZf.length);
            iArr4[this.fZf.length] = 8;
            this.fZf = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fZf.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.fZf.length) {
            return -1L;
        }
        return this.fZf[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return rm(this.fZf[i]) ? 0 : 1;
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
        if (i < 0 || i >= this.fZf.length) {
            return null;
        }
        int i2 = this.fZf[i];
        int i3 = this.fZd[i];
        if (rm(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(bEo(), bEp()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, rn(i2), ro(i2));
            alaMasterOperationSwitchItemView2.h(this.fZe[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(bEo(), bEp()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, rp(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.fZh);
        return alaMasterOperationSwitchItemView;
    }

    private boolean rm(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int bEo() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return this.fZa;
        }
        return -1;
    }

    private int bEp() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? this.fZc : this.fZb;
    }

    private int rn(int i) {
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

    private int ro(int i) {
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

    private int rp(int i) {
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
    public int rq(int i) {
        for (int i2 = 0; i2 < this.fZf.length; i2++) {
            if (this.fZf[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int rq = rq(i);
        if (rq >= 0) {
            this.fZe[rq] = s;
        }
    }

    public void a(InterfaceC0566a interfaceC0566a) {
        this.fZg = interfaceC0566a;
    }
}
