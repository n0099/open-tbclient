package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bq;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private int[] hJb;
    private short[] hJc;
    private int[] hJd;
    private InterfaceC0685a hJe;
    private Context mContext;
    private final int hIY = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds160);
    public final int hIZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds152);
    public final int hJa = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) * 2)) / 4;
    private View.OnClickListener foD = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int xq = a.this.xq(itemId);
                if (xq >= 0) {
                    if (a.this.hJc[xq] == 1) {
                        a.this.hJc[xq] = 2;
                    } else if (a.this.hJc[xq] == 2) {
                        a.this.hJc[xq] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.hJc[xq] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.hJe != null) {
                a.this.hJe.L(i, z);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0685a {
        void L(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.hJb = new int[]{a.h.ala_operation_panel_text_mute, 0, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
                this.hJd = new int[]{4, 0, 5, 6};
            } else {
                this.hJb = new int[]{a.h.ala_operation_panel_text_mute, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
                this.hJd = new int[]{4, 5, 6};
            }
            this.hJc = new short[]{1, 1, 1};
            return;
        }
        this.hJb = new int[]{a.h.ala_operation_panel_text_camera, a.h.ala_operation_panel_text_falshing, a.h.ala_operation_panel_text_mirror_off, a.h.ala_operation_panel_text_mute, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
        this.hJc = new short[]{1, 1, 1, 1, 1, 1};
        this.hJd = new int[]{1, 2, 3, 4, 5, 6};
        bq bqVar = com.baidu.live.af.a.SE().bCb;
        if (bqVar != null && bqVar.aRE != null && bqVar.aRE.aUi) {
            int[] iArr = new int[this.hJb.length + 1];
            System.arraycopy(this.hJb, 0, iArr, 0, this.hJb.length);
            iArr[this.hJb.length] = a.h.ala_operation_panel_text_redpacket;
            this.hJb = iArr;
            short[] sArr = new short[this.hJc.length + 1];
            System.arraycopy(this.hJc, 0, sArr, 0, this.hJc.length);
            sArr[this.hJc.length] = 1;
            this.hJc = sArr;
            int[] iArr2 = new int[this.hJd.length + 1];
            System.arraycopy(this.hJd, 0, iArr2, 0, this.hJd.length);
            iArr2[this.hJd.length] = 7;
            this.hJd = iArr2;
        }
        if (bqVar != null && bqVar.aRz != null && bqVar.aRz.Fj()) {
            int[] iArr3 = new int[this.hJb.length + 1];
            System.arraycopy(this.hJb, 0, iArr3, 0, this.hJb.length);
            iArr3[this.hJb.length] = a.h.ala_operation_panel_text_host_wish;
            this.hJb = iArr3;
            short[] sArr2 = new short[this.hJc.length + 1];
            System.arraycopy(this.hJc, 0, sArr2, 0, this.hJc.length);
            sArr2[this.hJc.length] = 1;
            this.hJc = sArr2;
            int[] iArr4 = new int[this.hJd.length + 1];
            System.arraycopy(this.hJd, 0, iArr4, 0, this.hJd.length);
            iArr4[this.hJd.length] = 8;
            this.hJd = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hJd.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.hJd.length) {
            return -1L;
        }
        return this.hJd[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return xm(this.hJd[i]) ? 0 : 1;
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
        if (i < 0 || i >= this.hJd.length) {
            return null;
        }
        int i2 = this.hJd[i];
        int i3 = this.hJb[i];
        if (xm(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(clv(), clw()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, xn(i2), xo(i2));
            alaMasterOperationSwitchItemView2.i(this.hJc[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(clv(), clw()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, xp(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.foD);
        return alaMasterOperationSwitchItemView;
    }

    private boolean xm(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int clv() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return this.hIY;
        }
        return -1;
    }

    private int clw() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? this.hJa : this.hIZ;
    }

    private int xn(int i) {
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

    private int xo(int i) {
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

    private int xp(int i) {
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
    public int xq(int i) {
        for (int i2 = 0; i2 < this.hJd.length; i2++) {
            if (this.hJd[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int xq = xq(i);
        if (xq >= 0) {
            this.hJc[xq] = s;
        }
    }

    public void a(InterfaceC0685a interfaceC0685a) {
        this.hJe = interfaceC0685a;
    }
}
