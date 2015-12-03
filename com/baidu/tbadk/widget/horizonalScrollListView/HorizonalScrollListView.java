package com.baidu.tbadk.widget.horizonalScrollListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
public class HorizonalScrollListView extends g {
    private LinearLayout aCh;
    private final ArrayList<a> aCi;
    private View.OnClickListener aCj;
    private View aCk;
    private String aCl;
    private String aCm;
    private CustomMessageListener aCn;
    private CustomMessageListener aCo;
    private View.OnClickListener aCp;
    private View.OnClickListener aCq;
    private String mFrom;
    private int mSkinType;
    private TbPageContext<?> mTbPageContext;

    public String getFrom() {
        return this.mFrom;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void ao(String str, String str2) {
        this.aCl = str;
        String str3 = this.aCm;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.aCi = new ArrayList<>();
        this.mSkinType = 3;
        this.aCj = null;
        this.aCn = new com.baidu.tbadk.widget.horizonalScrollListView.a(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.aCo = new b(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.aCp = new c(this);
        this.aCq = new e(this);
        aj(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCi = new ArrayList<>();
        this.mSkinType = 3;
        this.aCj = null;
        this.aCn = new com.baidu.tbadk.widget.horizonalScrollListView.a(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.aCo = new b(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.aCp = new c(this);
        this.aCq = new e(this);
        aj(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCi = new ArrayList<>();
        this.mSkinType = 3;
        this.aCj = null;
        this.aCn = new com.baidu.tbadk.widget.horizonalScrollListView.a(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.aCo = new b(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.aCp = new c(this);
        this.aCq = new e(this);
        aj(context);
    }

    private void aj(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.aCh = new LinearLayout(context);
        this.aCh.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.aCh.setOrientation(0);
        addView(this.aCh);
    }

    public void a(List<f> list, TbPageContext<?> tbPageContext) {
        if (y.k(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new f());
            int k = y.k(this.aCi);
            int k2 = y.k(list);
            if (k > k2) {
                for (int i = 0; i < k - k2; i++) {
                    x.a aVar = (x.a) y.b(this.aCi, i);
                    if (aVar != null) {
                        this.aCh.removeView(aVar.getView());
                    }
                    this.aCi.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < k2; i2++) {
                f fVar = (f) y.b(list, i2);
                a aVar2 = (a) y.b(this.aCi, i2);
                if (aVar2 != null) {
                    b(aVar2.getView(), fVar);
                } else {
                    View nv = nv();
                    if (nv != null) {
                        a aVar3 = new a(nv);
                        this.aCi.add(aVar3);
                        b(aVar3.getView(), fVar);
                        this.aCh.addView(nv);
                    }
                }
                if (i2 == k2 - 1) {
                    a(this.aCi.get(k2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.aCn);
            this.mTbPageContext.registerListener(this.aCo);
            cZ(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.aCk = aVar.getView();
            aVar.aCy.setVisibility(8);
            aVar.aCw.setText(this.mTbPageContext.getPageActivity().getResources().getString(n.i.recommend_frs_hot_thread_more));
            aVar.aCx.setVisibility(8);
            aVar.aCv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            as.c(aVar.aCv, n.e.icon_pic_more);
            as.b(aVar.aCw, n.c.cp_cont_b, 1);
            as.i(aVar.aCv, n.e.selector_load_more_bg);
            this.aCk.setClickable(true);
            this.aCk.setOnClickListener(this.aCj);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.aCj = onClickListener;
    }

    public View getLastItemView() {
        return this.aCk;
    }

    private void a(View view, f fVar) {
        if (view != null && view.getTag() != null && fVar != null) {
            a aVar = (a) view.getTag();
            aVar.aCy.setClickable(true);
            aVar.aCy.setOnClickListener(this.aCp);
            view.setClickable(true);
            view.setOnClickListener(this.aCq);
        }
    }

    private View nv() {
        return View.inflate(this.mTbPageContext.getPageActivity(), n.g.widget_hot_forum_list_item, null);
    }

    private void b(View view, f fVar) {
        if (fVar != null && view != null && view.getTag() != null) {
            a aVar = (a) view.getTag();
            aVar.aCv.setTag(fVar.forumAvatar);
            aVar.aCv.d(fVar.forumAvatar, 10, false);
            aVar.aCw.setText(fVar.forumName);
            aVar.aCw.setTag(n.f.tag_forum_id, Long.valueOf(fVar.forumId));
            aVar.aCx.setDefaultBgResource(0);
            aVar.aCx.setDefaultResource(0);
            aVar.aCy.setTag(n.f.tag_forum_id, Long.valueOf(fVar.forumId));
            aVar.aCy.setTag(n.f.tag_forum_name, fVar.forumName);
            aVar.getView().setTag(n.f.tag_forum_id, Long.valueOf(fVar.forumId));
            aVar.getView().setTag(n.f.tag_forum_name, fVar.forumName);
            a(aVar.aCy, fVar.isLiked);
            switch (fVar.rank) {
                case 1:
                    aVar.aCx.setVisibility(0);
                    as.c(aVar.aCx, n.e.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar.aCx.setVisibility(0);
                    as.c(aVar.aCx, n.e.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar.aCx.setVisibility(0);
                    as.c(aVar.aCx, n.e.icon_grade_shaitu3);
                    break;
                default:
                    aVar.aCx.setVisibility(8);
                    break;
            }
            a(view, fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, boolean z) {
        textView.setTag(n.f.forum_follow, Boolean.valueOf(z));
        if (z) {
            textView.setEnabled(false);
            as.b(textView, n.c.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m411getInst().getString(n.i.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            return;
        }
        as.b(textView, n.c.cp_cont_i, 1);
        textView.setText(TbadkCoreApplication.m411getInst().getString(n.i.forum_list_attention_tv));
        as.i((View) textView, n.e.btn_appdownload);
        textView.setEnabled(true);
    }

    public void cZ(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.aCi.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.aCk != null) {
                BarImageView barImageView = (BarImageView) this.aCk.findViewById(n.f.forum_avatar);
                as.i(barImageView, n.e.selector_load_more_bg);
                as.c(barImageView, n.e.icon_pic_more);
                as.b((TextView) this.aCk.findViewById(n.f.m_forum_name_textview), n.c.cp_cont_b, 1);
            }
            int k = y.k(this.aCi);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < k) {
                    a aVar = (a) y.b(this.aCi, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                as.c(aVar.aCx, n.e.icon_grade_shaitu1);
                                continue;
                            case 2:
                                as.c(aVar.aCx, n.e.icon_grade_shaitu2);
                                continue;
                            case 3:
                                as.c(aVar.aCx, n.e.icon_grade_shaitu3);
                                continue;
                        }
                    }
                    i2 = i3 + 1;
                }
            }
            this.mSkinType = i;
        }
    }

    private void a(a aVar, int i) {
        if (aVar != null && aVar.getView() != null) {
            if (aVar.aCy.getTag(n.f.forum_follow) != null && (aVar.aCy.getTag(n.f.forum_follow) instanceof Boolean)) {
                a(aVar.aCy, ((Boolean) aVar.aCy.getTag(n.f.forum_follow)).booleanValue());
            }
            as.b(aVar.aCw, n.c.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, boolean z) {
        Iterator<a> it = this.aCi.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.aCw.getTag(n.f.tag_forum_id) != null) {
                TextView textView = next.aCy;
                if (((Long) next.aCw.getTag(n.f.tag_forum_id)).longValue() == j) {
                    a(textView, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends x.a {
        public BarImageView aCv;
        public TextView aCw;
        public TbImageView aCx;
        public TextView aCy;

        public a(View view) {
            super(view);
            this.aCv = null;
            this.aCw = null;
            this.aCx = null;
            this.aCy = null;
            this.aCv = (BarImageView) view.findViewById(n.f.forum_avatar);
            this.aCv.setGifIconSupport(false);
            this.aCw = (TextView) view.findViewById(n.f.m_forum_name_textview);
            this.aCx = (TbImageView) view.findViewById(n.f.hot_rank);
            this.aCy = (TextView) view.findViewById(n.f.forum_add_love);
        }
    }
}
