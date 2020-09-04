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
    private LineView fdc;
    private ArrayList<b> fdd;
    private a fde;
    private int fdf;
    private int fdg;
    private int fdh;
    private int fdi;
    private LinearLayout mContainer;
    private int mSkinType;

    /* loaded from: classes15.dex */
    public interface a {
        void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData);
    }

    public MaxSignItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fdd = new ArrayList<>();
        this.fdh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.fdi = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    public MaxSignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fdd = new ArrayList<>();
        this.fdh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.fdi = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    public MaxSignItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fdd = new ArrayList<>();
        this.fdh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.fdi = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.max_sign_dialog_cus_view, (ViewGroup) this, true);
        this.mContainer = (LinearLayout) findViewById(R.id.sign_item_container);
        this.fdc = (LineView) findViewById(R.id.line_view);
        this.fdf = l.getDimens(getContext(), R.dimen.tbds3);
        this.fdg = l.getDimens(getContext(), R.dimen.tbds0);
    }

    public void setItemClickListener(a aVar) {
        this.fde = aVar;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.fdc.onChangeSkinType();
            Iterator<b> it = this.fdd.iterator();
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
                        if (marginLayoutParams.leftMargin != this.fdg || marginLayoutParams.rightMargin != this.fdg) {
                            marginLayoutParams.leftMargin = this.fdg;
                            marginLayoutParams.rightMargin = this.fdg;
                            setLayoutParams(marginLayoutParams);
                        }
                    } else if (marginLayoutParams.leftMargin != this.fdf || marginLayoutParams.rightMargin != this.fdf) {
                        marginLayoutParams.leftMargin = this.fdf;
                        marginLayoutParams.rightMargin = this.fdf;
                        setLayoutParams(layoutParams);
                    }
                }
                if (this.fdc.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fdc.getLayoutParams();
                    if (size <= 3) {
                        if (marginLayoutParams2.leftMargin != this.fdh || marginLayoutParams2.rightMargin != this.fdh) {
                            marginLayoutParams2.leftMargin = this.fdh;
                            marginLayoutParams2.rightMargin = this.fdh;
                            this.fdc.setLayoutParams(marginLayoutParams2);
                        }
                    } else if (marginLayoutParams2.leftMargin != this.fdi || marginLayoutParams2.rightMargin != this.fdi) {
                        marginLayoutParams2.leftMargin = this.fdi;
                        marginLayoutParams2.rightMargin = this.fdi;
                        this.fdc.setLayoutParams(marginLayoutParams2);
                    }
                }
                this.mContainer.removeAllViews();
                this.fdd.clear();
                for (int i = 0; i < size; i++) {
                    this.fdd.add(a(arrayList.get(i)));
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
        bVar.fdq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.mission.MaxSignItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!bVar.fds) {
                    Iterator it = MaxSignItemView.this.fdd.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).jV(false);
                    }
                    bVar.jV(true);
                    if (MaxSignItemView.this.fde == null) {
                        return;
                    }
                    MaxSignItemView.this.fde.b(bVar.fdt);
                }
            }
        });
        return bVar;
    }

    /* loaded from: classes15.dex */
    public static class b {
        private int fdp;
        private ImageView fdq;
        private CircleView fdr;
        private ActiveCenterData.ActiveCenterStatusData fdt;
        private View itemView;
        private TextView textView;
        private int fdl = R.drawable.ic_pic_mask_task_complete_svg;
        private int fdm = R.drawable.ic_pic_mask_task_select_svg;
        private int fdn = R.drawable.ic_pic_mask_task_comingsoon_svg;
        private int fdo = R.drawable.ic_pic_mask_task_uncomplete_svg;
        private boolean fds = false;

        public b(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            this.fdp = this.fdn;
            this.fdt = activeCenterStatusData;
            this.itemView = view;
            this.fdq = (ImageView) this.itemView.findViewById(R.id.item_icon);
            this.textView = (TextView) this.itemView.findViewById(R.id.item_text);
            this.fdr = (CircleView) this.itemView.findViewById(R.id.select_circle);
            this.fdr.setVisibility(4);
            if (activeCenterStatusData.is_today_mission == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.fdp = this.fdl;
                } else {
                    this.fdp = this.fdo;
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.fdr.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.fdp = this.fdl;
                } else {
                    this.fdp = this.fdm;
                }
            } else {
                this.fdp = this.fdn;
            }
            SvgManager.bjq().a(this.fdq, this.fdp, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.textView, R.color.cp_cont_d);
            this.textView.setText(activeCenterStatusData.day + "天");
        }

        public void onChangeSkinType() {
            SvgManager.bjq().a(this.fdq, this.fdp, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.textView, R.color.cp_cont_d);
            this.fdr.onChangeSkinType();
        }

        public void jV(boolean z) {
            if (z) {
                this.fds = true;
                this.fdr.setVisibility(0);
                return;
            }
            this.fds = false;
            this.fdr.setVisibility(4);
        }
    }
}
