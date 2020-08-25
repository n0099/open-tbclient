package com.baidu.tbadk.widget.mission;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes15.dex */
public class MaxSignItemView extends FrameLayout {
    private LineView fcY;
    private ArrayList<b> fcZ;
    private a fda;
    private int fdb;
    private int fdc;
    private int fdd;
    private int fde;
    private LinearLayout mContainer;
    private int mSkinType;

    /* loaded from: classes15.dex */
    public interface a {
        void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData);
    }

    public MaxSignItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fcZ = new ArrayList<>();
        this.fdd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.fde = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    public MaxSignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fcZ = new ArrayList<>();
        this.fdd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.fde = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    public MaxSignItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fcZ = new ArrayList<>();
        this.fdd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.fde = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.max_sign_dialog_cus_view, (ViewGroup) this, true);
        this.mContainer = (LinearLayout) findViewById(R.id.sign_item_container);
        this.fcY = (LineView) findViewById(R.id.line_view);
        this.fdb = l.getDimens(getContext(), R.dimen.tbds3);
        this.fdc = l.getDimens(getContext(), R.dimen.tbds0);
    }

    public void setItemClickListener(a aVar) {
        this.fda = aVar;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.fcY.onChangeSkinType();
            Iterator<b> it = this.fcZ.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    public void setData(ActiveCenterData activeCenterData) {
        if (activeCenterData != null) {
            ArrayList<ActiveCenterData.ActiveCenterStatusData> arrayList = activeCenterData.mission_status_list;
            int size = arrayList.size();
            if (arrayList != null && size != 0) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (size <= 3) {
                        if (marginLayoutParams.leftMargin != this.fdc || marginLayoutParams.rightMargin != this.fdc) {
                            marginLayoutParams.leftMargin = this.fdc;
                            marginLayoutParams.rightMargin = this.fdc;
                            setLayoutParams(marginLayoutParams);
                        }
                    } else if (marginLayoutParams.leftMargin != this.fdb || marginLayoutParams.rightMargin != this.fdb) {
                        marginLayoutParams.leftMargin = this.fdb;
                        marginLayoutParams.rightMargin = this.fdb;
                        setLayoutParams(layoutParams);
                    }
                }
                if (this.fcY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fcY.getLayoutParams();
                    if (size <= 3) {
                        if (marginLayoutParams2.leftMargin != this.fdd || marginLayoutParams2.rightMargin != this.fdd) {
                            marginLayoutParams2.leftMargin = this.fdd;
                            marginLayoutParams2.rightMargin = this.fdd;
                            this.fcY.setLayoutParams(marginLayoutParams2);
                        }
                    } else if (marginLayoutParams2.leftMargin != this.fde || marginLayoutParams2.rightMargin != this.fde) {
                        marginLayoutParams2.leftMargin = this.fde;
                        marginLayoutParams2.rightMargin = this.fde;
                        this.fcY.setLayoutParams(marginLayoutParams2);
                    }
                }
                this.mContainer.removeAllViews();
                this.fcZ.clear();
                for (int i = 0; i < size; i++) {
                    this.fcZ.add(a(arrayList.get(i)));
                }
            }
        }
    }

    private b a(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.max_sing_dialog_item_view, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        this.mContainer.addView(inflate, layoutParams);
        final b bVar = new b(inflate, activeCenterStatusData);
        bVar.fdm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.mission.MaxSignItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!bVar.fdo) {
                    Iterator it = MaxSignItemView.this.fcZ.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).jT(false);
                    }
                    bVar.jT(true);
                    if (MaxSignItemView.this.fda == null) {
                        return;
                    }
                    MaxSignItemView.this.fda.b(bVar.fdp);
                }
            }
        });
        return bVar;
    }

    /* loaded from: classes15.dex */
    public static class b {
        private int fdl;
        private ImageView fdm;
        private CircleView fdn;
        private ActiveCenterData.ActiveCenterStatusData fdp;
        private View itemView;
        private TextView textView;
        private int fdh = R.drawable.ic_pic_mask_task_complete_svg;
        private int fdi = R.drawable.ic_pic_mask_task_select_svg;
        private int fdj = R.drawable.ic_pic_mask_task_comingsoon_svg;
        private int fdk = R.drawable.ic_pic_mask_task_uncomplete_svg;
        private boolean fdo = false;

        public b(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            this.fdl = this.fdj;
            this.fdp = activeCenterStatusData;
            this.itemView = view;
            this.fdm = (ImageView) this.itemView.findViewById(R.id.item_icon);
            this.textView = (TextView) this.itemView.findViewById(R.id.item_text);
            this.fdn = (CircleView) this.itemView.findViewById(R.id.select_circle);
            this.fdn.setVisibility(4);
            if (activeCenterStatusData.is_today_mission == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.fdl = this.fdh;
                } else {
                    this.fdl = this.fdk;
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.fdn.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.fdl = this.fdh;
                } else {
                    this.fdl = this.fdi;
                }
            } else {
                this.fdl = this.fdj;
            }
            SvgManager.bjq().a(this.fdm, this.fdl, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.textView, R.color.cp_cont_d);
            this.textView.setText(activeCenterStatusData.day + "天");
        }

        public void onChangeSkinType() {
            SvgManager.bjq().a(this.fdm, this.fdl, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.textView, R.color.cp_cont_d);
            this.fdn.onChangeSkinType();
        }

        public void jT(boolean z) {
            if (z) {
                this.fdo = true;
                this.fdn.setVisibility(0);
                return;
            }
            this.fdo = false;
            this.fdn.setVisibility(4);
        }
    }
}
