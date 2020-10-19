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
/* loaded from: classes21.dex */
public class MaxSignItemView extends FrameLayout {
    private LineView fsj;
    private ArrayList<b> fsk;
    private a fsl;
    private int fsm;
    private int fsn;
    private int fso;
    private int fsp;
    private LinearLayout mContainer;
    private int mSkinType;

    /* loaded from: classes21.dex */
    public interface a {
        void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData);
    }

    public MaxSignItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fsk = new ArrayList<>();
        this.fso = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.fsp = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    public MaxSignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fsk = new ArrayList<>();
        this.fso = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.fsp = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    public MaxSignItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fsk = new ArrayList<>();
        this.fso = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.fsp = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.max_sign_dialog_cus_view, (ViewGroup) this, true);
        this.mContainer = (LinearLayout) findViewById(R.id.sign_item_container);
        this.fsj = (LineView) findViewById(R.id.line_view);
        this.fsm = l.getDimens(getContext(), R.dimen.tbds3);
        this.fsn = l.getDimens(getContext(), R.dimen.tbds0);
    }

    public void setItemClickListener(a aVar) {
        this.fsl = aVar;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.fsj.onChangeSkinType();
            Iterator<b> it = this.fsk.iterator();
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
                        if (marginLayoutParams.leftMargin != this.fsn || marginLayoutParams.rightMargin != this.fsn) {
                            marginLayoutParams.leftMargin = this.fsn;
                            marginLayoutParams.rightMargin = this.fsn;
                            setLayoutParams(marginLayoutParams);
                        }
                    } else if (marginLayoutParams.leftMargin != this.fsm || marginLayoutParams.rightMargin != this.fsm) {
                        marginLayoutParams.leftMargin = this.fsm;
                        marginLayoutParams.rightMargin = this.fsm;
                        setLayoutParams(layoutParams);
                    }
                }
                if (this.fsj.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fsj.getLayoutParams();
                    if (size <= 3) {
                        if (marginLayoutParams2.leftMargin != this.fso || marginLayoutParams2.rightMargin != this.fso) {
                            marginLayoutParams2.leftMargin = this.fso;
                            marginLayoutParams2.rightMargin = this.fso;
                            this.fsj.setLayoutParams(marginLayoutParams2);
                        }
                    } else if (marginLayoutParams2.leftMargin != this.fsp || marginLayoutParams2.rightMargin != this.fsp) {
                        marginLayoutParams2.leftMargin = this.fsp;
                        marginLayoutParams2.rightMargin = this.fsp;
                        this.fsj.setLayoutParams(marginLayoutParams2);
                    }
                }
                this.mContainer.removeAllViews();
                this.fsk.clear();
                for (int i = 0; i < size; i++) {
                    this.fsk.add(a(arrayList.get(i)));
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
        bVar.fsx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.mission.MaxSignItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!bVar.fsz) {
                    Iterator it = MaxSignItemView.this.fsk.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).ku(false);
                    }
                    bVar.ku(true);
                    if (MaxSignItemView.this.fsl == null) {
                        return;
                    }
                    MaxSignItemView.this.fsl.b(bVar.fsA);
                }
            }
        });
        return bVar;
    }

    /* loaded from: classes21.dex */
    public static class b {
        private ActiveCenterData.ActiveCenterStatusData fsA;
        private int fsw;
        private ImageView fsx;
        private CircleView fsy;
        private View itemView;
        private TextView textView;
        private int fss = R.drawable.ic_pic_mask_task_complete_svg;
        private int fst = R.drawable.ic_pic_mask_task_select_svg;
        private int fsu = R.drawable.ic_pic_mask_task_comingsoon_svg;
        private int fsv = R.drawable.ic_pic_mask_task_uncomplete_svg;
        private boolean fsz = false;

        public b(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            this.fsw = this.fsu;
            this.fsA = activeCenterStatusData;
            this.itemView = view;
            this.fsx = (ImageView) this.itemView.findViewById(R.id.item_icon);
            this.textView = (TextView) this.itemView.findViewById(R.id.item_text);
            this.fsy = (CircleView) this.itemView.findViewById(R.id.select_circle);
            this.fsy.setVisibility(4);
            if (activeCenterStatusData.is_today_mission == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.fsw = this.fss;
                } else {
                    this.fsw = this.fsv;
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.fsy.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.fsw = this.fss;
                } else {
                    this.fsw = this.fst;
                }
            } else {
                this.fsw = this.fsu;
            }
            SvgManager.bmU().a(this.fsx, this.fsw, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.textView, R.color.cp_cont_d);
            this.textView.setText(activeCenterStatusData.day + "天");
        }

        public void onChangeSkinType() {
            SvgManager.bmU().a(this.fsx, this.fsw, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.textView, R.color.cp_cont_d);
            this.fsy.onChangeSkinType();
        }

        public void ku(boolean z) {
            if (z) {
                this.fsz = true;
                this.fsy.setVisibility(0);
                return;
            }
            this.fsz = false;
            this.fsy.setVisibility(4);
        }
    }
}
