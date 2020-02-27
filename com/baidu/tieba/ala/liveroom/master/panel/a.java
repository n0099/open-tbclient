package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ap;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private static final int ffY = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
    public static final int ffZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds152);
    public static final int fga = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
    private int[] fgb;
    private short[] fgc;
    private int[] fgd;
    private InterfaceC0463a fge;
    private View.OnClickListener fgf = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int qu = a.this.qu(itemId);
                if (qu >= 0) {
                    if (a.this.fgc[qu] == 1) {
                        a.this.fgc[qu] = 2;
                    } else if (a.this.fgc[qu] == 2) {
                        a.this.fgc[qu] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.fgc[qu] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.fge != null) {
                a.this.fge.z(i, z);
            }
        }
    };
    private Context mContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0463a {
        void z(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.fgb = new int[]{a.i.ala_operation_panel_text_mute, 0, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.fgd = new int[]{4, 0, 5, 6};
            } else {
                this.fgb = new int[]{a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.fgd = new int[]{4, 5, 6};
            }
            this.fgc = new short[]{1, 1, 1};
            return;
        }
        this.fgb = new int[]{a.i.ala_operation_panel_text_camera, a.i.ala_operation_panel_text_falshing, a.i.ala_operation_panel_text_mirror_off, a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
        this.fgc = new short[]{1, 1, 1, 1, 1, 1};
        this.fgd = new int[]{1, 2, 3, 4, 5, 6};
        ap apVar = com.baidu.live.v.a.zj().axB;
        if (apVar != null && apVar.acV != null && apVar.acV.aeC) {
            int[] iArr = new int[this.fgb.length + 1];
            System.arraycopy(this.fgb, 0, iArr, 0, this.fgb.length);
            iArr[this.fgb.length] = a.i.ala_operation_panel_text_redpacket;
            this.fgb = iArr;
            short[] sArr = new short[this.fgc.length + 1];
            System.arraycopy(this.fgc, 0, sArr, 0, this.fgc.length);
            sArr[this.fgc.length] = 1;
            this.fgc = sArr;
            int[] iArr2 = new int[this.fgd.length + 1];
            System.arraycopy(this.fgd, 0, iArr2, 0, this.fgd.length);
            iArr2[this.fgd.length] = 7;
            this.fgd = iArr2;
        }
        if (apVar != null && apVar.acQ != null && apVar.acQ.qK()) {
            int[] iArr3 = new int[this.fgb.length + 1];
            System.arraycopy(this.fgb, 0, iArr3, 0, this.fgb.length);
            iArr3[this.fgb.length] = a.i.ala_operation_panel_text_host_wish;
            this.fgb = iArr3;
            short[] sArr2 = new short[this.fgc.length + 1];
            System.arraycopy(this.fgc, 0, sArr2, 0, this.fgc.length);
            sArr2[this.fgc.length] = 1;
            this.fgc = sArr2;
            int[] iArr4 = new int[this.fgd.length + 1];
            System.arraycopy(this.fgd, 0, iArr4, 0, this.fgd.length);
            iArr4[this.fgd.length] = 8;
            this.fgd = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fgd.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.fgd.length) {
            return -1L;
        }
        return this.fgd[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return qq(this.fgd[i]) ? 0 : 1;
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
        if (i < 0 || i >= this.fgd.length) {
            return null;
        }
        int i2 = this.fgd[i];
        int i3 = this.fgb[i];
        if (qq(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(getItemWidth(), boM()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, qr(i2), qs(i2));
            alaMasterOperationSwitchItemView2.h(this.fgc[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(getItemWidth(), boM()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, qt(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.fgf);
        return alaMasterOperationSwitchItemView;
    }

    private boolean qq(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int getItemWidth() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return ffY;
        }
        return -1;
    }

    private int boM() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? fga : ffZ;
    }

    private int qr(int i) {
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

    private int qs(int i) {
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

    private int qt(int i) {
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
    public int qu(int i) {
        for (int i2 = 0; i2 < this.fgd.length; i2++) {
            if (this.fgd[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int qu = qu(i);
        if (qu >= 0) {
            this.fgc[qu] = s;
        }
    }

    public void a(InterfaceC0463a interfaceC0463a) {
        this.fge = interfaceC0463a;
    }
}
