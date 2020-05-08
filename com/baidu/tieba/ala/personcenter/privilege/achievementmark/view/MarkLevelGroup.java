package com.baidu.tieba.ala.personcenter.privilege.achievementmark.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MarkLevelGroup extends LinearLayout {
    private LinearLayout gbQ;
    private List<View> gbR;
    private a gbS;

    /* loaded from: classes3.dex */
    public interface a {
        void dl(String str, String str2);
    }

    public MarkLevelGroup(Context context) {
        super(context);
        initView();
    }

    public MarkLevelGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public MarkLevelGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public void setCallback(a aVar) {
        this.gbS = aVar;
    }

    private void initView() {
        setOrientation(0);
        setGravity(1);
        LayoutInflater.from(getContext()).inflate(R.layout.ala_achievement_mark_level_layout, (ViewGroup) this, true);
        this.gbQ = (LinearLayout) findViewById(R.id.mark_level_list_container);
    }

    public void c(b bVar) {
        if (bVar != null) {
            List<d> bCb = bVar.bCb();
            if (v.isEmpty(bCb)) {
                if (getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = getLayoutParams();
                    layoutParams.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds118);
                    setLayoutParams(layoutParams);
                }
                setVisibility(4);
                return;
            }
            setVisibility(0);
            this.gbQ.removeAllViews();
            if (this.gbR == null) {
                this.gbR = new ArrayList();
            } else {
                this.gbR.clear();
            }
            int size = bCb.size();
            for (int i = 0; i < size; i++) {
                final d dVar = bCb.get(i);
                if (dVar != null) {
                    View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_achievement_mark_level_item_view, (ViewGroup) null);
                    FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.mark_level_layout);
                    TextView textView = (TextView) inflate.findViewById(R.id.mark_level_tv);
                    textView.setText(String.valueOf(i + 1));
                    ((TextView) inflate.findViewById(R.id.mark_level_score_tv)).setText(AlaStringHelper.numFormatMarkLevel(dVar.bCm()));
                    this.gbR.add(inflate);
                    boolean z = bVar.bCg() == 0;
                    if (bVar.bCi() == dVar.bCi()) {
                        a(frameLayout, true);
                        if (z) {
                            textView.setBackgroundResource(R.drawable.pic_live_honor_show_off);
                        } else {
                            textView.setBackgroundResource(R.drawable.pic_live_honor_show_on);
                        }
                    } else if (bVar.bCi() > dVar.bCi()) {
                        a(frameLayout, false);
                        if (z) {
                            textView.setBackgroundResource(R.drawable.pic_live_honor_show_off);
                        } else {
                            textView.setBackgroundResource(R.drawable.pic_live_honor_show_on);
                        }
                    } else if (bVar.bCi() < dVar.bCi()) {
                        a(frameLayout, false);
                        textView.setBackgroundResource(R.drawable.pic_live_honor_show_off);
                    }
                    inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            for (View view2 : MarkLevelGroup.this.gbR) {
                                if (view == view2) {
                                    MarkLevelGroup.this.a((FrameLayout) view2.findViewById(R.id.mark_level_layout), true);
                                } else {
                                    MarkLevelGroup.this.a((FrameLayout) view2.findViewById(R.id.mark_level_layout), false);
                                }
                            }
                            if (MarkLevelGroup.this.gbS != null) {
                                MarkLevelGroup.this.gbS.dl(dVar.bCf(), dVar.bCe());
                            }
                        }
                    });
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) inflate.getLayoutParams();
                    if (layoutParams2 == null) {
                        layoutParams2 = new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.ds82), -2);
                    } else {
                        layoutParams2.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds82);
                        layoutParams2.height = -2;
                    }
                    this.gbQ.addView(inflate, layoutParams2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FrameLayout frameLayout, boolean z) {
        if (z) {
            frameLayout.setBackgroundResource(R.drawable.pic_live_honor_show_s);
        } else {
            frameLayout.setBackgroundResource(0);
        }
    }
}
