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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes15.dex */
public class SignItemView extends FrameLayout {
    private a eSJ;
    private LineView eSr;
    private ArrayList<b> eSs;
    private int eSu;
    private int eSv;
    private int eSw;
    private int eSx;
    private LinearLayout mContainer;
    private int mSkinType;

    /* loaded from: classes15.dex */
    public interface a {
        void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData);
    }

    public SignItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eSs = new ArrayList<>();
        this.eSw = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.eSx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    public SignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eSs = new ArrayList<>();
        this.eSw = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.eSx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    public SignItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eSs = new ArrayList<>();
        this.eSw = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.eSx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.sign_dialog_cus_view, (ViewGroup) this, true);
        this.mContainer = (LinearLayout) findViewById(R.id.sign_item_container);
        this.eSr = (LineView) findViewById(R.id.line_view);
        this.eSu = l.getDimens(getContext(), R.dimen.tbds23);
        this.eSv = l.getDimens(getContext(), R.dimen.tbds26);
    }

    public void setItemClickListener(a aVar) {
        this.eSJ = aVar;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.eSr.onChangeSkinType();
            Iterator<b> it = this.eSs.iterator();
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
                this.mContainer.removeAllViews();
                this.eSs.clear();
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (size <= 3) {
                        marginLayoutParams.leftMargin = this.eSv;
                        marginLayoutParams.rightMargin = this.eSv;
                    } else {
                        marginLayoutParams.leftMargin = this.eSu;
                        marginLayoutParams.rightMargin = this.eSu;
                    }
                    setLayoutParams(marginLayoutParams);
                }
                if (this.eSr.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.eSr.getLayoutParams();
                    if (size <= 3) {
                        if (marginLayoutParams2.leftMargin != this.eSw || marginLayoutParams2.rightMargin != this.eSw) {
                            marginLayoutParams2.leftMargin = this.eSw;
                            marginLayoutParams2.rightMargin = this.eSw;
                            this.eSr.setLayoutParams(marginLayoutParams2);
                        }
                    } else if (marginLayoutParams2.leftMargin != this.eSx || marginLayoutParams2.rightMargin != this.eSx) {
                        marginLayoutParams2.leftMargin = this.eSx;
                        marginLayoutParams2.rightMargin = this.eSx;
                        this.eSr.setLayoutParams(marginLayoutParams2);
                    }
                }
                for (int i = 0; i < size; i++) {
                    this.eSs.add(c(arrayList.get(i)));
                }
            }
        }
    }

    private b c(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.sing_dialog_item_view, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        this.mContainer.addView(inflate, layoutParams);
        final b bVar = new b(inflate, activeCenterStatusData);
        bVar.eSF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.mission.SignItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!bVar.eSH) {
                    Iterator it = SignItemView.this.eSs.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).jv(false);
                    }
                    bVar.jv(true);
                    if (SignItemView.this.eSJ == null) {
                        return;
                    }
                    SignItemView.this.eSJ.b(bVar.eSI);
                }
            }
        });
        return bVar;
    }

    /* loaded from: classes15.dex */
    public static class b {
        private int eSE;
        private ImageView eSF;
        private CircleView eSG;
        private ActiveCenterData.ActiveCenterStatusData eSI;
        private View itemView;
        private TextView textView;
        private int eSA = R.drawable.ic_pic_mask_task_complete_svg;
        private int eSB = R.drawable.ic_pic_mask_task_select_svg;
        private int eSC = R.drawable.ic_pic_mask_task_comingsoon_svg;
        private int eSD = R.drawable.ic_pic_mask_task_uncomplete_svg;
        private boolean eSH = false;

        public b(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            this.eSE = this.eSC;
            this.eSI = activeCenterStatusData;
            this.itemView = view;
            this.eSF = (ImageView) this.itemView.findViewById(R.id.item_icon);
            this.textView = (TextView) this.itemView.findViewById(R.id.item_text);
            this.eSG = (CircleView) this.itemView.findViewById(R.id.select_circle);
            this.eSG.setVisibility(4);
            if (activeCenterStatusData.is_today_mission == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.eSE = this.eSA;
                } else {
                    this.eSE = this.eSD;
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.eSG.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.eSE = this.eSA;
                } else {
                    this.eSE = this.eSB;
                }
            } else {
                this.eSE = this.eSC;
            }
            SvgManager.baR().a(this.eSF, this.eSE, SvgManager.SvgResourceStateType.NORMAL);
            ao.setViewTextColor(this.textView, R.color.cp_cont_d);
            this.textView.setText(activeCenterStatusData.day + "天");
        }

        public void onChangeSkinType() {
            SvgManager.baR().a(this.eSF, this.eSE, SvgManager.SvgResourceStateType.NORMAL);
            ao.setViewTextColor(this.textView, R.color.cp_cont_d);
            this.eSG.onChangeSkinType();
        }

        public void jv(boolean z) {
            if (z) {
                this.eSH = true;
                this.eSG.setVisibility(0);
                return;
            }
            this.eSH = false;
            this.eSG.setVisibility(4);
        }
    }
}
