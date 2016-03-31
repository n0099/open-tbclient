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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a extends h {
    private LinearLayout aGa;
    private final ArrayList<C0058a> aGb;
    private View.OnClickListener aGc;
    private View aGd;
    private String aGe;
    private String aGf;
    private CustomMessageListener aGg;
    private CustomMessageListener aGh;
    private View.OnClickListener aGi;
    private View.OnClickListener aGj;
    private String adH;
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
            if (this.aGh != null) {
                this.aGh.setTag(this.mTag);
            }
            if (this.aGg != null) {
                this.aGg.setTag(this.mTag);
            }
        }
    }

    public String getFrom() {
        return this.adH;
    }

    public void setFrom(String str) {
        this.adH = str;
    }

    public void at(String str, String str2) {
        this.aGe = str;
        this.aGf = str2;
    }

    public a(Context context) {
        super(context);
        this.aGb = new ArrayList<>();
        this.mSkinType = 3;
        this.aGc = null;
        this.mTag = null;
        this.aGg = new b(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.aGh = new c(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.aGi = new d(this);
        this.aGj = new f(this);
        ak(context);
    }

    private void ak(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.aGa = new LinearLayout(context);
        this.aGa.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.aGa.setOrientation(0);
        addView(this.aGa);
    }

    public void a(List<g> list, TbPageContext<?> tbPageContext) {
        if (y.p(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new g());
            int p = y.p(this.aGb);
            int p2 = y.p(list);
            if (p > p2) {
                for (int i = 0; i < p - p2; i++) {
                    x.a aVar = (x.a) y.b(this.aGb, i);
                    if (aVar != null) {
                        this.aGa.removeView(aVar.getView());
                    }
                    this.aGb.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < p2; i2++) {
                g gVar = (g) y.b(list, i2);
                C0058a c0058a = (C0058a) y.b(this.aGb, i2);
                if (c0058a != null) {
                    b(c0058a.getView(), gVar);
                } else {
                    View mZ = mZ();
                    if (mZ != null) {
                        C0058a c0058a2 = new C0058a(mZ);
                        this.aGb.add(c0058a2);
                        b(c0058a2.getView(), gVar);
                        this.aGa.addView(mZ);
                    }
                }
                if (i2 == p2 - 1) {
                    a(this.aGb.get(p2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.aGg);
            this.mTbPageContext.registerListener(this.aGh);
            if (getTag() != null) {
                this.aGg.setTag(getTag());
                this.aGh.setTag(getTag());
            }
            de(this.mSkinType);
        }
    }

    private void a(C0058a c0058a) {
        if (c0058a != null) {
            this.aGd = c0058a.getView();
            c0058a.aGr.setVisibility(8);
            c0058a.aGp.setText(this.mTbPageContext.getPageActivity().getResources().getString(t.j.recommend_frs_hot_thread_more));
            c0058a.aGq.setVisibility(8);
            c0058a.aGo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            at.c(c0058a.aGo, t.f.icon_pic_more);
            at.b(c0058a.aGp, t.d.cp_cont_b, 1);
            at.k(c0058a.aGo, t.f.selector_load_more_bg);
            this.aGd.setClickable(true);
            this.aGd.setOnClickListener(this.aGc);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.aGc = onClickListener;
    }

    public View getLastItemView() {
        return this.aGd;
    }

    private void a(View view, g gVar) {
        if (view != null && view.getTag() != null && gVar != null) {
            C0058a c0058a = (C0058a) view.getTag();
            c0058a.aGr.setClickable(true);
            c0058a.aGr.setOnClickListener(this.aGi);
            view.setClickable(true);
            view.setOnClickListener(this.aGj);
        }
    }

    private View mZ() {
        return View.inflate(this.mTbPageContext.getPageActivity(), t.h.widget_hot_forum_list_item, null);
    }

    private void b(View view, g gVar) {
        if (gVar != null && view != null && view.getTag() != null) {
            C0058a c0058a = (C0058a) view.getTag();
            c0058a.aGo.setTag(gVar.forumAvatar);
            c0058a.aGo.c(gVar.forumAvatar, 10, false);
            c0058a.aGp.setText(gVar.forumName);
            c0058a.aGp.setTag(t.g.tag_forum_id, Long.valueOf(gVar.forumId));
            c0058a.aGq.setDefaultBgResource(0);
            c0058a.aGq.setDefaultResource(0);
            c0058a.aGr.setTag(t.g.tag_forum_id, Long.valueOf(gVar.forumId));
            c0058a.aGr.setTag(t.g.tag_forum_name, gVar.forumName);
            c0058a.getView().setTag(t.g.tag_forum_id, Long.valueOf(gVar.forumId));
            c0058a.getView().setTag(t.g.tag_forum_name, gVar.forumName);
            a(c0058a.aGr, gVar.isLiked);
            switch (gVar.rank) {
                case 1:
                    c0058a.aGq.setVisibility(0);
                    at.c(c0058a.aGq, t.f.icon_grade_shaitu1);
                    break;
                case 2:
                    c0058a.aGq.setVisibility(0);
                    at.c(c0058a.aGq, t.f.icon_grade_shaitu2);
                    break;
                case 3:
                    c0058a.aGq.setVisibility(0);
                    at.c(c0058a.aGq, t.f.icon_grade_shaitu3);
                    break;
                default:
                    c0058a.aGq.setVisibility(8);
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
            at.b(textView, t.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m411getInst().getString(t.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            return;
        }
        at.b(textView, t.d.cp_cont_i, 1);
        textView.setText(TbadkCoreApplication.m411getInst().getString(t.j.forum_list_attention_tv));
        at.k(textView, t.f.btn_appdownload);
        textView.setEnabled(true);
    }

    public void de(int i) {
        if (this.mSkinType != i) {
            Iterator<C0058a> it = this.aGb.iterator();
            while (it.hasNext()) {
                C0058a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.aGd != null) {
                BarImageView barImageView = (BarImageView) this.aGd.findViewById(t.g.forum_avatar);
                at.k(barImageView, t.f.selector_load_more_bg);
                at.c(barImageView, t.f.icon_pic_more);
                at.b((TextView) this.aGd.findViewById(t.g.m_forum_name_textview), t.d.cp_cont_b, 1);
            }
            int p = y.p(this.aGb);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < p) {
                    C0058a c0058a = (C0058a) y.b(this.aGb, i3);
                    if (c0058a != null) {
                        switch (i3 + 1) {
                            case 1:
                                at.c(c0058a.aGq, t.f.icon_grade_shaitu1);
                                continue;
                            case 2:
                                at.c(c0058a.aGq, t.f.icon_grade_shaitu2);
                                continue;
                            case 3:
                                at.c(c0058a.aGq, t.f.icon_grade_shaitu3);
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
            if (c0058a.aGr.getTag(t.g.forum_follow) != null && (c0058a.aGr.getTag(t.g.forum_follow) instanceof Boolean)) {
                a(c0058a.aGr, ((Boolean) c0058a.aGr.getTag(t.g.forum_follow)).booleanValue());
            }
            at.b(c0058a.aGp, t.d.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, boolean z) {
        Iterator<C0058a> it = this.aGb.iterator();
        while (it.hasNext()) {
            C0058a next = it.next();
            if (next != null && next.getView() != null && next.aGp.getTag(t.g.tag_forum_id) != null) {
                TextView textView = next.aGr;
                if (((Long) next.aGp.getTag(t.g.tag_forum_id)).longValue() == j) {
                    a(textView, z);
                    return;
                }
            }
        }
    }

    /* renamed from: com.baidu.tbadk.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0058a extends x.a {
        public BarImageView aGo;
        public TextView aGp;
        public TbImageView aGq;
        public TextView aGr;

        public C0058a(View view) {
            super(view);
            this.aGo = null;
            this.aGp = null;
            this.aGq = null;
            this.aGr = null;
            this.aGo = (BarImageView) view.findViewById(t.g.forum_avatar);
            this.aGo.setGifIconSupport(false);
            this.aGp = (TextView) view.findViewById(t.g.m_forum_name_textview);
            this.aGq = (TbImageView) view.findViewById(t.g.hot_rank);
            this.aGr = (TextView) view.findViewById(t.g.forum_add_love);
        }
    }
}
