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
    private int[] fZo;
    private short[] fZp;
    private int[] fZq;
    private InterfaceC0566a fZr;
    private Context mContext;
    private final int fZl = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
    public final int fZm = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds152);
    public final int fZn = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
    private View.OnClickListener fZs = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int rs = a.this.rs(itemId);
                if (rs >= 0) {
                    if (a.this.fZp[rs] == 1) {
                        a.this.fZp[rs] = 2;
                    } else if (a.this.fZp[rs] == 2) {
                        a.this.fZp[rs] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.fZp[rs] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.fZr != null) {
                a.this.fZr.F(i, z);
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
                this.fZo = new int[]{a.i.ala_operation_panel_text_mute, 0, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.fZq = new int[]{4, 0, 5, 6};
            } else {
                this.fZo = new int[]{a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.fZq = new int[]{4, 5, 6};
            }
            this.fZp = new short[]{1, 1, 1};
            return;
        }
        this.fZo = new int[]{a.i.ala_operation_panel_text_camera, a.i.ala_operation_panel_text_falshing, a.i.ala_operation_panel_text_mirror_off, a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
        this.fZp = new short[]{1, 1, 1, 1, 1, 1};
        this.fZq = new int[]{1, 2, 3, 4, 5, 6};
        ax axVar = com.baidu.live.v.a.Ge().aYP;
        if (axVar != null && axVar.aAL != null && axVar.aAL.aCx) {
            int[] iArr = new int[this.fZo.length + 1];
            System.arraycopy(this.fZo, 0, iArr, 0, this.fZo.length);
            iArr[this.fZo.length] = a.i.ala_operation_panel_text_redpacket;
            this.fZo = iArr;
            short[] sArr = new short[this.fZp.length + 1];
            System.arraycopy(this.fZp, 0, sArr, 0, this.fZp.length);
            sArr[this.fZp.length] = 1;
            this.fZp = sArr;
            int[] iArr2 = new int[this.fZq.length + 1];
            System.arraycopy(this.fZq, 0, iArr2, 0, this.fZq.length);
            iArr2[this.fZq.length] = 7;
            this.fZq = iArr2;
        }
        if (axVar != null && axVar.aAG != null && axVar.aAG.wu()) {
            int[] iArr3 = new int[this.fZo.length + 1];
            System.arraycopy(this.fZo, 0, iArr3, 0, this.fZo.length);
            iArr3[this.fZo.length] = a.i.ala_operation_panel_text_host_wish;
            this.fZo = iArr3;
            short[] sArr2 = new short[this.fZp.length + 1];
            System.arraycopy(this.fZp, 0, sArr2, 0, this.fZp.length);
            sArr2[this.fZp.length] = 1;
            this.fZp = sArr2;
            int[] iArr4 = new int[this.fZq.length + 1];
            System.arraycopy(this.fZq, 0, iArr4, 0, this.fZq.length);
            iArr4[this.fZq.length] = 8;
            this.fZq = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fZq.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.fZq.length) {
            return -1L;
        }
        return this.fZq[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ro(this.fZq[i]) ? 0 : 1;
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
        if (i < 0 || i >= this.fZq.length) {
            return null;
        }
        int i2 = this.fZq[i];
        int i3 = this.fZo[i];
        if (ro(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(bEq(), bEr()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, rp(i2), rq(i2));
            alaMasterOperationSwitchItemView2.h(this.fZp[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(bEq(), bEr()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, rr(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.fZs);
        return alaMasterOperationSwitchItemView;
    }

    private boolean ro(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int bEq() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return this.fZl;
        }
        return -1;
    }

    private int bEr() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? this.fZn : this.fZm;
    }

    private int rp(int i) {
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

    private int rq(int i) {
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

    private int rr(int i) {
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
    public int rs(int i) {
        for (int i2 = 0; i2 < this.fZq.length; i2++) {
            if (this.fZq[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int rs = rs(i);
        if (rs >= 0) {
            this.fZp[rs] = s;
        }
    }

    public void a(InterfaceC0566a interfaceC0566a) {
        this.fZr = interfaceC0566a;
    }
}
