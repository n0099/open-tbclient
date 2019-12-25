package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ak;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private static final int fab = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds160);
    public static final int fac = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds152);
    public static final int fad = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) * 2)) / 4;
    private int[] fae;
    private short[] faf;
    private int[] fag;
    private InterfaceC0449a fah;
    private View.OnClickListener fai = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int qi = a.this.qi(itemId);
                if (qi >= 0) {
                    if (a.this.faf[qi] == 1) {
                        a.this.faf[qi] = 2;
                    } else if (a.this.faf[qi] == 2) {
                        a.this.faf[qi] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.faf[qi] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.fah != null) {
                a.this.fah.A(i, z);
            }
        }
    };
    private Context mContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0449a {
        void A(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.fae = new int[]{a.i.ala_operation_panel_text_mute, 0, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.fag = new int[]{4, 0, 5, 6};
            } else {
                this.fae = new int[]{a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
                this.fag = new int[]{4, 5, 6};
            }
            this.faf = new short[]{1, 1, 1};
            return;
        }
        this.fae = new int[]{a.i.ala_operation_panel_text_camera, a.i.ala_operation_panel_text_falshing, a.i.ala_operation_panel_text_mirror_off, a.i.ala_operation_panel_text_mute, a.i.ala_operation_panel_text_admin, a.i.ala_operation_panel_text_black};
        this.faf = new short[]{1, 1, 1, 1, 1, 1};
        this.fag = new int[]{1, 2, 3, 4, 5, 6};
        ak akVar = com.baidu.live.r.a.wA().asy;
        if (akVar != null && akVar.aaK != null && akVar.aaK.aco) {
            int[] iArr = new int[this.fae.length + 1];
            System.arraycopy(this.fae, 0, iArr, 0, this.fae.length);
            iArr[this.fae.length] = a.i.ala_operation_panel_text_redpacket;
            this.fae = iArr;
            short[] sArr = new short[this.faf.length + 1];
            System.arraycopy(this.faf, 0, sArr, 0, this.faf.length);
            sArr[this.faf.length] = 1;
            this.faf = sArr;
            int[] iArr2 = new int[this.fag.length + 1];
            System.arraycopy(this.fag, 0, iArr2, 0, this.fag.length);
            iArr2[this.fag.length] = 7;
            this.fag = iArr2;
        }
        if (akVar != null && akVar.aaF != null && akVar.aaF.pT()) {
            int[] iArr3 = new int[this.fae.length + 1];
            System.arraycopy(this.fae, 0, iArr3, 0, this.fae.length);
            iArr3[this.fae.length] = a.i.ala_operation_panel_text_host_wish;
            this.fae = iArr3;
            short[] sArr2 = new short[this.faf.length + 1];
            System.arraycopy(this.faf, 0, sArr2, 0, this.faf.length);
            sArr2[this.faf.length] = 1;
            this.faf = sArr2;
            int[] iArr4 = new int[this.fag.length + 1];
            System.arraycopy(this.fag, 0, iArr4, 0, this.fag.length);
            iArr4[this.fag.length] = 8;
            this.fag = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fag.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.fag.length) {
            return -1L;
        }
        return this.fag[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return qe(this.fag[i]) ? 0 : 1;
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
        if (i < 0 || i >= this.fag.length) {
            return null;
        }
        int i2 = this.fag[i];
        int i3 = this.fae[i];
        if (qe(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(getItemWidth(), bme()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, qf(i2), qg(i2));
            alaMasterOperationSwitchItemView2.f(this.faf[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(getItemWidth(), bme()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, qh(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.fai);
        return alaMasterOperationSwitchItemView;
    }

    private boolean qe(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int getItemWidth() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return fab;
        }
        return -1;
    }

    private int bme() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? fad : fac;
    }

    private int qf(int i) {
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

    private int qg(int i) {
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

    private int qh(int i) {
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
    public int qi(int i) {
        for (int i2 = 0; i2 < this.fag.length; i2++) {
            if (this.fag[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int qi = qi(i);
        if (qi >= 0) {
            this.faf[qi] = s;
        }
    }

    public void a(InterfaceC0449a interfaceC0449a) {
        this.fah = interfaceC0449a;
    }
}
