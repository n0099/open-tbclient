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
    private int[] hnu;
    private short[] hnv;
    private int[] hnw;
    private InterfaceC0680a hnx;
    private Context mContext;
    private final int hnr = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds160);
    public final int hns = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds152);
    public final int hnt = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) * 2)) / 4;
    private View.OnClickListener eXy = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int wA = a.this.wA(itemId);
                if (wA >= 0) {
                    if (a.this.hnv[wA] == 1) {
                        a.this.hnv[wA] = 2;
                    } else if (a.this.hnv[wA] == 2) {
                        a.this.hnv[wA] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.hnv[wA] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.hnx != null) {
                a.this.hnx.L(i, z);
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
                this.hnu = new int[]{a.h.ala_operation_panel_text_mute, 0, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
                this.hnw = new int[]{4, 0, 5, 6};
            } else {
                this.hnu = new int[]{a.h.ala_operation_panel_text_mute, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
                this.hnw = new int[]{4, 5, 6};
            }
            this.hnv = new short[]{1, 1, 1};
            return;
        }
        this.hnu = new int[]{a.h.ala_operation_panel_text_camera, a.h.ala_operation_panel_text_falshing, a.h.ala_operation_panel_text_mirror_off, a.h.ala_operation_panel_text_mute, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
        this.hnv = new short[]{1, 1, 1, 1, 1, 1};
        this.hnw = new int[]{1, 2, 3, 4, 5, 6};
        bn bnVar = com.baidu.live.aa.a.Ph().bsh;
        if (bnVar != null && bnVar.aNP != null && bnVar.aNP.aQi) {
            int[] iArr = new int[this.hnu.length + 1];
            System.arraycopy(this.hnu, 0, iArr, 0, this.hnu.length);
            iArr[this.hnu.length] = a.h.ala_operation_panel_text_redpacket;
            this.hnu = iArr;
            short[] sArr = new short[this.hnv.length + 1];
            System.arraycopy(this.hnv, 0, sArr, 0, this.hnv.length);
            sArr[this.hnv.length] = 1;
            this.hnv = sArr;
            int[] iArr2 = new int[this.hnw.length + 1];
            System.arraycopy(this.hnw, 0, iArr2, 0, this.hnw.length);
            iArr2[this.hnw.length] = 7;
            this.hnw = iArr2;
        }
        if (bnVar != null && bnVar.aNK != null && bnVar.aNK.Ei()) {
            int[] iArr3 = new int[this.hnu.length + 1];
            System.arraycopy(this.hnu, 0, iArr3, 0, this.hnu.length);
            iArr3[this.hnu.length] = a.h.ala_operation_panel_text_host_wish;
            this.hnu = iArr3;
            short[] sArr2 = new short[this.hnv.length + 1];
            System.arraycopy(this.hnv, 0, sArr2, 0, this.hnv.length);
            sArr2[this.hnv.length] = 1;
            this.hnv = sArr2;
            int[] iArr4 = new int[this.hnw.length + 1];
            System.arraycopy(this.hnw, 0, iArr4, 0, this.hnw.length);
            iArr4[this.hnw.length] = 8;
            this.hnw = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hnw.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.hnw.length) {
            return -1L;
        }
        return this.hnw[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ww(this.hnw[i]) ? 0 : 1;
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
        if (i < 0 || i >= this.hnw.length) {
            return null;
        }
        int i2 = this.hnw[i];
        int i3 = this.hnu[i];
        if (ww(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(ceK(), ceL()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, wx(i2), wy(i2));
            alaMasterOperationSwitchItemView2.i(this.hnv[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(ceK(), ceL()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, wz(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.eXy);
        return alaMasterOperationSwitchItemView;
    }

    private boolean ww(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int ceK() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return this.hnr;
        }
        return -1;
    }

    private int ceL() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? this.hnt : this.hns;
    }

    private int wx(int i) {
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

    private int wy(int i) {
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

    private int wz(int i) {
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
    public int wA(int i) {
        for (int i2 = 0; i2 < this.hnw.length; i2++) {
            if (this.hnw[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int wA = wA(i);
        if (wA >= 0) {
            this.hnv[wA] = s;
        }
    }

    public void a(InterfaceC0680a interfaceC0680a) {
        this.hnx = interfaceC0680a;
    }
}
