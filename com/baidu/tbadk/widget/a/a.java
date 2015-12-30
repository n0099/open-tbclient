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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a extends h {
    private LinearLayout aDP;
    private final ArrayList<C0057a> aDQ;
    private View.OnClickListener aDR;
    private View aDS;
    private String aDT;
    private String aDU;
    private CustomMessageListener aDV;
    private CustomMessageListener aDW;
    private View.OnClickListener aDX;
    private View.OnClickListener aDY;
    private String mFrom;
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
            if (this.aDW != null) {
                this.aDW.setTag(this.mTag);
            }
            if (this.aDV != null) {
                this.aDV.setTag(this.mTag);
            }
        }
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void an(String str, String str2) {
        this.aDT = str;
        this.aDU = str2;
    }

    public a(Context context) {
        super(context);
        this.aDQ = new ArrayList<>();
        this.mSkinType = 3;
        this.aDR = null;
        this.mTag = null;
        this.aDV = new b(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.aDW = new c(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.aDX = new d(this);
        this.aDY = new f(this);
        am(context);
    }

    private void am(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.aDP = new LinearLayout(context);
        this.aDP.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.aDP.setOrientation(0);
        addView(this.aDP);
    }

    public void a(List<g> list, TbPageContext<?> tbPageContext) {
        if (y.l(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new g());
            int l = y.l(this.aDQ);
            int l2 = y.l(list);
            if (l > l2) {
                for (int i = 0; i < l - l2; i++) {
                    x.a aVar = (x.a) y.b(this.aDQ, i);
                    if (aVar != null) {
                        this.aDP.removeView(aVar.getView());
                    }
                    this.aDQ.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < l2; i2++) {
                g gVar = (g) y.b(list, i2);
                C0057a c0057a = (C0057a) y.b(this.aDQ, i2);
                if (c0057a != null) {
                    b(c0057a.getView(), gVar);
                } else {
                    View mT = mT();
                    if (mT != null) {
                        C0057a c0057a2 = new C0057a(mT);
                        this.aDQ.add(c0057a2);
                        b(c0057a2.getView(), gVar);
                        this.aDP.addView(mT);
                    }
                }
                if (i2 == l2 - 1) {
                    a(this.aDQ.get(l2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.aDV);
            this.mTbPageContext.registerListener(this.aDW);
            if (getTag() != null) {
                this.aDV.setTag(getTag());
                this.aDW.setTag(getTag());
            }
            cK(this.mSkinType);
        }
    }

    private void a(C0057a c0057a) {
        if (c0057a != null) {
            this.aDS = c0057a.getView();
            c0057a.aEg.setVisibility(8);
            c0057a.aEe.setText(this.mTbPageContext.getPageActivity().getResources().getString(n.j.recommend_frs_hot_thread_more));
            c0057a.aEf.setVisibility(8);
            c0057a.aEd.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            as.c(c0057a.aEd, n.f.icon_pic_more);
            as.b(c0057a.aEe, n.d.cp_cont_b, 1);
            as.i(c0057a.aEd, n.f.selector_load_more_bg);
            this.aDS.setClickable(true);
            this.aDS.setOnClickListener(this.aDR);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.aDR = onClickListener;
    }

    public View getLastItemView() {
        return this.aDS;
    }

    private void a(View view, g gVar) {
        if (view != null && view.getTag() != null && gVar != null) {
            C0057a c0057a = (C0057a) view.getTag();
            c0057a.aEg.setClickable(true);
            c0057a.aEg.setOnClickListener(this.aDX);
            view.setClickable(true);
            view.setOnClickListener(this.aDY);
        }
    }

    private View mT() {
        return View.inflate(this.mTbPageContext.getPageActivity(), n.h.widget_hot_forum_list_item, null);
    }

    private void b(View view, g gVar) {
        if (gVar != null && view != null && view.getTag() != null) {
            C0057a c0057a = (C0057a) view.getTag();
            c0057a.aEd.setTag(gVar.forumAvatar);
            c0057a.aEd.d(gVar.forumAvatar, 10, false);
            c0057a.aEe.setText(gVar.forumName);
            c0057a.aEe.setTag(n.g.tag_forum_id, Long.valueOf(gVar.forumId));
            c0057a.aEf.setDefaultBgResource(0);
            c0057a.aEf.setDefaultResource(0);
            c0057a.aEg.setTag(n.g.tag_forum_id, Long.valueOf(gVar.forumId));
            c0057a.aEg.setTag(n.g.tag_forum_name, gVar.forumName);
            c0057a.getView().setTag(n.g.tag_forum_id, Long.valueOf(gVar.forumId));
            c0057a.getView().setTag(n.g.tag_forum_name, gVar.forumName);
            a(c0057a.aEg, gVar.isLiked);
            switch (gVar.rank) {
                case 1:
                    c0057a.aEf.setVisibility(0);
                    as.c(c0057a.aEf, n.f.icon_grade_shaitu1);
                    break;
                case 2:
                    c0057a.aEf.setVisibility(0);
                    as.c(c0057a.aEf, n.f.icon_grade_shaitu2);
                    break;
                case 3:
                    c0057a.aEf.setVisibility(0);
                    as.c(c0057a.aEf, n.f.icon_grade_shaitu3);
                    break;
                default:
                    c0057a.aEf.setVisibility(8);
                    break;
            }
            a(view, gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, boolean z) {
        textView.setTag(n.g.forum_follow, Boolean.valueOf(z));
        if (z) {
            textView.setEnabled(false);
            as.b(textView, n.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m411getInst().getString(n.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            return;
        }
        as.b(textView, n.d.cp_cont_i, 1);
        textView.setText(TbadkCoreApplication.m411getInst().getString(n.j.forum_list_attention_tv));
        as.i((View) textView, n.f.btn_appdownload);
        textView.setEnabled(true);
    }

    public void cK(int i) {
        if (this.mSkinType != i) {
            Iterator<C0057a> it = this.aDQ.iterator();
            while (it.hasNext()) {
                C0057a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.aDS != null) {
                BarImageView barImageView = (BarImageView) this.aDS.findViewById(n.g.forum_avatar);
                as.i(barImageView, n.f.selector_load_more_bg);
                as.c(barImageView, n.f.icon_pic_more);
                as.b((TextView) this.aDS.findViewById(n.g.m_forum_name_textview), n.d.cp_cont_b, 1);
            }
            int l = y.l(this.aDQ);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < l) {
                    C0057a c0057a = (C0057a) y.b(this.aDQ, i3);
                    if (c0057a != null) {
                        switch (i3 + 1) {
                            case 1:
                                as.c(c0057a.aEf, n.f.icon_grade_shaitu1);
                                continue;
                            case 2:
                                as.c(c0057a.aEf, n.f.icon_grade_shaitu2);
                                continue;
                            case 3:
                                as.c(c0057a.aEf, n.f.icon_grade_shaitu3);
                                continue;
                        }
                    }
                    i2 = i3 + 1;
                }
            }
            this.mSkinType = i;
        }
    }

    private void a(C0057a c0057a, int i) {
        if (c0057a != null && c0057a.getView() != null) {
            if (c0057a.aEg.getTag(n.g.forum_follow) != null && (c0057a.aEg.getTag(n.g.forum_follow) instanceof Boolean)) {
                a(c0057a.aEg, ((Boolean) c0057a.aEg.getTag(n.g.forum_follow)).booleanValue());
            }
            as.b(c0057a.aEe, n.d.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, boolean z) {
        Iterator<C0057a> it = this.aDQ.iterator();
        while (it.hasNext()) {
            C0057a next = it.next();
            if (next != null && next.getView() != null && next.aEe.getTag(n.g.tag_forum_id) != null) {
                TextView textView = next.aEg;
                if (((Long) next.aEe.getTag(n.g.tag_forum_id)).longValue() == j) {
                    a(textView, z);
                    return;
                }
            }
        }
    }

    /* renamed from: com.baidu.tbadk.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0057a extends x.a {
        public BarImageView aEd;
        public TextView aEe;
        public TbImageView aEf;
        public TextView aEg;

        public C0057a(View view) {
            super(view);
            this.aEd = null;
            this.aEe = null;
            this.aEf = null;
            this.aEg = null;
            this.aEd = (BarImageView) view.findViewById(n.g.forum_avatar);
            this.aEd.setGifIconSupport(false);
            this.aEe = (TextView) view.findViewById(n.g.m_forum_name_textview);
            this.aEf = (TbImageView) view.findViewById(n.g.hot_rank);
            this.aEg = (TextView) view.findViewById(n.g.forum_add_love);
        }
    }
}
