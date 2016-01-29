package com.baidu.tbadk.widget.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a extends h {
    private LinearLayout aEF;
    private final ArrayList<C0058a> aEG;
    private View.OnClickListener aEH;
    private View aEI;
    private String aEJ;
    private String aEK;
    private CustomMessageListener aEL;
    private CustomMessageListener aEM;
    private View.OnClickListener aEN;
    private View.OnClickListener aEO;
    private String aer;
    private int mSkinType;
    private BdUniqueId mTag;
    private TbPageContext<?> mTbPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public BdUniqueId getTag() {
        return this.mTag;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
        if (this.mTag != null) {
            if (this.aEM != null) {
                this.aEM.setTag(this.mTag);
            }
            if (this.aEL != null) {
                this.aEL.setTag(this.mTag);
            }
        }
    }

    public String getFrom() {
        return this.aer;
    }

    public void setFrom(String str) {
        this.aer = str;
    }

    public void an(String str, String str2) {
        this.aEJ = str;
        this.aEK = str2;
    }

    public a(Context context) {
        super(context);
        this.aEG = new ArrayList<>();
        this.mSkinType = 3;
        this.aEH = null;
        this.mTag = null;
        this.aEL = new b(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.aEM = new c(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.aEN = new d(this);
        this.aEO = new f(this);
        an(context);
    }

    private void an(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.aEF = new LinearLayout(context);
        this.aEF.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.aEF.setOrientation(0);
        addView(this.aEF);
    }

    public void a(List<g> list, TbPageContext<?> tbPageContext) {
        if (x.o(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new g());
            int o = x.o(this.aEG);
            int o2 = x.o(list);
            if (o > o2) {
                for (int i = 0; i < o - o2; i++) {
                    x.a aVar = (x.a) com.baidu.tbadk.core.util.x.b(this.aEG, i);
                    if (aVar != null) {
                        this.aEF.removeView(aVar.getView());
                    }
                    this.aEG.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < o2; i2++) {
                g gVar = (g) com.baidu.tbadk.core.util.x.b(list, i2);
                C0058a c0058a = (C0058a) com.baidu.tbadk.core.util.x.b(this.aEG, i2);
                if (c0058a != null) {
                    b(c0058a.getView(), gVar);
                } else {
                    View ni = ni();
                    if (ni != null) {
                        C0058a c0058a2 = new C0058a(ni);
                        this.aEG.add(c0058a2);
                        b(c0058a2.getView(), gVar);
                        this.aEF.addView(ni);
                    }
                }
                if (i2 == o2 - 1) {
                    a(this.aEG.get(o2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.aEL);
            this.mTbPageContext.registerListener(this.aEM);
            if (getTag() != null) {
                this.aEL.setTag(getTag());
                this.aEM.setTag(getTag());
            }
            db(this.mSkinType);
        }
    }

    private void a(C0058a c0058a) {
        if (c0058a != null) {
            this.aEI = c0058a.getView();
            c0058a.aEW.setVisibility(8);
            c0058a.aEU.setText(this.mTbPageContext.getPageActivity().getResources().getString(t.j.recommend_frs_hot_thread_more));
            c0058a.aEV.setVisibility(8);
            c0058a.aET.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ar.c(c0058a.aET, t.f.icon_pic_more);
            ar.b(c0058a.aEU, t.d.cp_cont_b, 1);
            ar.k(c0058a.aET, t.f.selector_load_more_bg);
            this.aEI.setClickable(true);
            this.aEI.setOnClickListener(this.aEH);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.aEH = onClickListener;
    }

    public View getLastItemView() {
        return this.aEI;
    }

    private void a(View view, g gVar) {
        if (view != null && view.getTag() != null && gVar != null) {
            C0058a c0058a = (C0058a) view.getTag();
            c0058a.aEW.setClickable(true);
            c0058a.aEW.setOnClickListener(this.aEN);
            view.setClickable(true);
            view.setOnClickListener(this.aEO);
        }
    }

    private View ni() {
        return View.inflate(this.mTbPageContext.getPageActivity(), t.h.widget_hot_forum_list_item, null);
    }

    private void b(View view, g gVar) {
        if (gVar != null && view != null && view.getTag() != null) {
            C0058a c0058a = (C0058a) view.getTag();
            c0058a.aET.setTag(gVar.forumAvatar);
            c0058a.aET.d(gVar.forumAvatar, 10, false);
            c0058a.aEU.setText(gVar.forumName);
            c0058a.aEU.setTag(t.g.tag_forum_id, Long.valueOf(gVar.forumId));
            c0058a.aEV.setDefaultBgResource(0);
            c0058a.aEV.setDefaultResource(0);
            c0058a.aEW.setTag(t.g.tag_forum_id, Long.valueOf(gVar.forumId));
            c0058a.aEW.setTag(t.g.tag_forum_name, gVar.forumName);
            c0058a.getView().setTag(t.g.tag_forum_id, Long.valueOf(gVar.forumId));
            c0058a.getView().setTag(t.g.tag_forum_name, gVar.forumName);
            a(c0058a.aEW, gVar.isLiked);
            switch (gVar.rank) {
                case 1:
                    c0058a.aEV.setVisibility(0);
                    ar.c(c0058a.aEV, t.f.icon_grade_shaitu1);
                    break;
                case 2:
                    c0058a.aEV.setVisibility(0);
                    ar.c(c0058a.aEV, t.f.icon_grade_shaitu2);
                    break;
                case 3:
                    c0058a.aEV.setVisibility(0);
                    ar.c(c0058a.aEV, t.f.icon_grade_shaitu3);
                    break;
                default:
                    c0058a.aEV.setVisibility(8);
                    break;
            }
            a(view, gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, boolean z) {
        textView.setTag(t.g.forum_follow, Boolean.valueOf(z));
        if (z) {
            textView.setEnabled(false);
            ar.b(textView, t.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m411getInst().getString(t.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            return;
        }
        ar.b(textView, t.d.cp_cont_i, 1);
        textView.setText(TbadkCoreApplication.m411getInst().getString(t.j.forum_list_attention_tv));
        ar.k(textView, t.f.btn_appdownload);
        textView.setEnabled(true);
    }

    public void db(int i) {
        if (this.mSkinType != i) {
            Iterator<C0058a> it = this.aEG.iterator();
            while (it.hasNext()) {
                C0058a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.aEI != null) {
                BarImageView barImageView = (BarImageView) this.aEI.findViewById(t.g.forum_avatar);
                ar.k(barImageView, t.f.selector_load_more_bg);
                ar.c(barImageView, t.f.icon_pic_more);
                ar.b((TextView) this.aEI.findViewById(t.g.m_forum_name_textview), t.d.cp_cont_b, 1);
            }
            int o = com.baidu.tbadk.core.util.x.o(this.aEG);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < o) {
                    C0058a c0058a = (C0058a) com.baidu.tbadk.core.util.x.b(this.aEG, i3);
                    if (c0058a != null) {
                        switch (i3 + 1) {
                            case 1:
                                ar.c(c0058a.aEV, t.f.icon_grade_shaitu1);
                                continue;
                            case 2:
                                ar.c(c0058a.aEV, t.f.icon_grade_shaitu2);
                                continue;
                            case 3:
                                ar.c(c0058a.aEV, t.f.icon_grade_shaitu3);
                                continue;
                        }
                    }
                    i2 = i3 + 1;
                }
            }
            this.mSkinType = i;
        }
    }

    private void a(C0058a c0058a, int i) {
        if (c0058a != null && c0058a.getView() != null) {
            if (c0058a.aEW.getTag(t.g.forum_follow) != null && (c0058a.aEW.getTag(t.g.forum_follow) instanceof Boolean)) {
                a(c0058a.aEW, ((Boolean) c0058a.aEW.getTag(t.g.forum_follow)).booleanValue());
            }
            ar.b(c0058a.aEU, t.d.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, boolean z) {
        Iterator<C0058a> it = this.aEG.iterator();
        while (it.hasNext()) {
            C0058a next = it.next();
            if (next != null && next.getView() != null && next.aEU.getTag(t.g.tag_forum_id) != null) {
                TextView textView = next.aEW;
                if (((Long) next.aEU.getTag(t.g.tag_forum_id)).longValue() == j) {
                    a(textView, z);
                    return;
                }
            }
        }
    }

    /* renamed from: com.baidu.tbadk.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0058a extends x.a {
        public BarImageView aET;
        public TextView aEU;
        public TbImageView aEV;
        public TextView aEW;

        public C0058a(View view) {
            super(view);
            this.aET = null;
            this.aEU = null;
            this.aEV = null;
            this.aEW = null;
            this.aET = (BarImageView) view.findViewById(t.g.forum_avatar);
            this.aET.setGifIconSupport(false);
            this.aEU = (TextView) view.findViewById(t.g.m_forum_name_textview);
            this.aEV = (TbImageView) view.findViewById(t.g.hot_rank);
            this.aEW = (TextView) view.findViewById(t.g.forum_add_love);
        }
    }
}
