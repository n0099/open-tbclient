package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bm;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private int[] hhV;
    private short[] hhW;
    private int[] hhX;
    private InterfaceC0666a hhY;
    private Context mContext;
    private final int hhS = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
    public final int hhT = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds152);
    public final int hhU = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
    private View.OnClickListener eSC = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int vP = a.this.vP(itemId);
                if (vP >= 0) {
                    if (a.this.hhW[vP] == 1) {
                        a.this.hhW[vP] = 2;
                    } else if (a.this.hhW[vP] == 2) {
                        a.this.hhW[vP] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.hhW[vP] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.hhY != null) {
                a.this.hhY.L(i, z);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0666a {
        void L(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.hhV = new int[]{a.i.ala_operation_panel_text_mute, 0, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.hhX = new int[]{4, 0, 5, 6};
            } else {
                this.hhV = new int[]{a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.hhX = new int[]{4, 5, 6};
            }
            this.hhW = new short[]{1, 1, 1};
            return;
        }
        this.hhV = new int[]{a.i.ala_operation_panel_text_camera, a.i.ala_operation_panel_text_falshing, a.i.ala_operation_panel_text_mirror_off, a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
        this.hhW = new short[]{1, 1, 1, 1, 1, 1};
        this.hhX = new int[]{1, 2, 3, 4, 5, 6};
        bm bmVar = com.baidu.live.z.a.Pq().bsy;
        if (bmVar != null && bmVar.aOD != null && bmVar.aOD.aQR) {
            int[] iArr = new int[this.hhV.length + 1];
            System.arraycopy(this.hhV, 0, iArr, 0, this.hhV.length);
            iArr[this.hhV.length] = a.i.ala_operation_panel_text_redpacket;
            this.hhV = iArr;
            short[] sArr = new short[this.hhW.length + 1];
            System.arraycopy(this.hhW, 0, sArr, 0, this.hhW.length);
            sArr[this.hhW.length] = 1;
            this.hhW = sArr;
            int[] iArr2 = new int[this.hhX.length + 1];
            System.arraycopy(this.hhX, 0, iArr2, 0, this.hhX.length);
            iArr2[this.hhX.length] = 7;
            this.hhX = iArr2;
        }
        if (bmVar != null && bmVar.aOy != null && bmVar.aOy.Eu()) {
            int[] iArr3 = new int[this.hhV.length + 1];
            System.arraycopy(this.hhV, 0, iArr3, 0, this.hhV.length);
            iArr3[this.hhV.length] = a.i.ala_operation_panel_text_host_wish;
            this.hhV = iArr3;
            short[] sArr2 = new short[this.hhW.length + 1];
            System.arraycopy(this.hhW, 0, sArr2, 0, this.hhW.length);
            sArr2[this.hhW.length] = 1;
            this.hhW = sArr2;
            int[] iArr4 = new int[this.hhX.length + 1];
            System.arraycopy(this.hhX, 0, iArr4, 0, this.hhX.length);
            iArr4[this.hhX.length] = 8;
            this.hhX = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hhX.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.hhX.length) {
            return -1L;
        }
        return this.hhX[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return vL(this.hhX[i]) ? 0 : 1;
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
        if (i < 0 || i >= this.hhX.length) {
            return null;
        }
        int i2 = this.hhX[i];
        int i3 = this.hhV[i];
        if (vL(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(ccQ(), ccR()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, vM(i2), vN(i2));
            alaMasterOperationSwitchItemView2.i(this.hhW[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(ccQ(), ccR()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, vO(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.eSC);
        return alaMasterOperationSwitchItemView;
    }

    private boolean vL(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int ccQ() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return this.hhS;
        }
        return -1;
    }

    private int ccR() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? this.hhU : this.hhT;
    }

    private int vM(int i) {
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

    private int vN(int i) {
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

    private int vO(int i) {
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
    public int vP(int i) {
        for (int i2 = 0; i2 < this.hhX.length; i2++) {
            if (this.hhX[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int vP = vP(i);
        if (vP >= 0) {
            this.hhW[vP] = s;
        }
    }

    public void a(InterfaceC0666a interfaceC0666a) {
        this.hhY = interfaceC0666a;
    }
}
