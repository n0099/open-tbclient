package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private static final int ejN = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
    public static final int ejO = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds152);
    public static final int ejP = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
    private final int[] ejQ;
    private final short[] ejR;
    private final int[] ejS;
    private InterfaceC0360a ejT;
    private View.OnClickListener ejU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int nR = a.this.nR(itemId);
                if (nR >= 0) {
                    if (a.this.ejR[nR] == 1) {
                        a.this.ejR[nR] = 2;
                    } else if (a.this.ejR[nR] == 2) {
                        a.this.ejR[nR] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.ejR[nR] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.ejT != null) {
                a.this.ejT.y(i, z);
            }
        }
    };
    private Context mContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0360a {
        void y(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.ejQ = new int[]{a.i.ala_operation_panel_text_mute, 0, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.ejS = new int[]{4, 0, 5, 6};
            } else {
                this.ejQ = new int[]{a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.ejS = new int[]{4, 5, 6};
            }
            this.ejR = new short[]{1, 1, 1};
            return;
        }
        this.ejQ = new int[]{a.i.ala_operation_panel_text_camera, a.i.ala_operation_panel_text_falshing, a.i.ala_operation_panel_text_mirror_off, a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
        this.ejR = new short[]{1, 1, 1, 1, 1, 1};
        this.ejS = new int[]{1, 2, 3, 4, 5, 6};
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ejS.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.ejS.length) {
            return -1L;
        }
        return this.ejS[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return nN(this.ejS[i]) ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return g(i, view);
    }

    private AlaMasterOperationBaseItemView g(int i, View view) {
        AlaMasterOperationEntryItemView alaMasterOperationEntryItemView;
        AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView;
        AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView2;
        if (i < 0 || i >= this.ejS.length) {
            return null;
        }
        int i2 = this.ejS[i];
        int i3 = this.ejQ[i];
        if (nN(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(aUm(), aUn()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, nO(i2), nP(i2));
            alaMasterOperationSwitchItemView2.e(this.ejR[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(aUm(), aUn()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, nQ(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.ejU);
        return alaMasterOperationSwitchItemView;
    }

    private boolean nN(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int aUm() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return ejN;
        }
        return -1;
    }

    private int aUn() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? ejP : ejO;
    }

    private int nO(int i) {
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

    private int nP(int i) {
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

    private int nQ(int i) {
        if (i == 5) {
            return a.f.btn_live_admin;
        }
        if (i == 6) {
            return a.f.btn_live_blacklist;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int nR(int i) {
        for (int i2 = 0; i2 < this.ejS.length; i2++) {
            if (this.ejS[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int nR = nR(i);
        if (nR >= 0) {
            this.ejR[nR] = s;
        }
    }

    public void a(InterfaceC0360a interfaceC0360a) {
        this.ejT = interfaceC0360a;
    }
}
