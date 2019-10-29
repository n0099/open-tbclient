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
    private static final int ekE = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
    public static final int ekF = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds152);
    public static final int ekG = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
    private final int[] ekH;
    private final short[] ekI;
    private final int[] ekJ;
    private InterfaceC0365a ekK;
    private View.OnClickListener ekL = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int nS = a.this.nS(itemId);
                if (nS >= 0) {
                    if (a.this.ekI[nS] == 1) {
                        a.this.ekI[nS] = 2;
                    } else if (a.this.ekI[nS] == 2) {
                        a.this.ekI[nS] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.ekI[nS] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.ekK != null) {
                a.this.ekK.y(i, z);
            }
        }
    };
    private Context mContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0365a {
        void y(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.ekH = new int[]{a.i.ala_operation_panel_text_mute, 0, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.ekJ = new int[]{4, 0, 5, 6};
            } else {
                this.ekH = new int[]{a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.ekJ = new int[]{4, 5, 6};
            }
            this.ekI = new short[]{1, 1, 1};
            return;
        }
        this.ekH = new int[]{a.i.ala_operation_panel_text_camera, a.i.ala_operation_panel_text_falshing, a.i.ala_operation_panel_text_mirror_off, a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
        this.ekI = new short[]{1, 1, 1, 1, 1, 1};
        this.ekJ = new int[]{1, 2, 3, 4, 5, 6};
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ekJ.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.ekJ.length) {
            return -1L;
        }
        return this.ekJ[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return nO(this.ekJ[i]) ? 0 : 1;
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
        if (i < 0 || i >= this.ekJ.length) {
            return null;
        }
        int i2 = this.ekJ[i];
        int i3 = this.ekH[i];
        if (nO(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(aUo(), aUp()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, nP(i2), nQ(i2));
            alaMasterOperationSwitchItemView2.f(this.ekI[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(aUo(), aUp()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, nR(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.ekL);
        return alaMasterOperationSwitchItemView;
    }

    private boolean nO(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int aUo() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return ekE;
        }
        return -1;
    }

    private int aUp() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? ekG : ekF;
    }

    private int nP(int i) {
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

    private int nQ(int i) {
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

    private int nR(int i) {
        if (i == 5) {
            return a.f.btn_live_admin;
        }
        if (i == 6) {
            return a.f.btn_live_blacklist;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int nS(int i) {
        for (int i2 = 0; i2 < this.ekJ.length; i2++) {
            if (this.ekJ[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int nS = nS(i);
        if (nS >= 0) {
            this.ekI[nS] = s;
        }
    }

    public void a(InterfaceC0365a interfaceC0365a) {
        this.ekK = interfaceC0365a;
    }
}
