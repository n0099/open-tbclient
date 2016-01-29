package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class j extends com.baidu.tbadk.widget.a.h {
    private LinearLayout aEF;
    private final ArrayList<a> aEG;
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

    public j(Context context) {
        super(context);
        this.aEG = new ArrayList<>();
        this.mSkinType = 3;
        this.aEH = null;
        this.mTag = null;
        this.aEL = new k(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.aEM = new l(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.aEN = new m(this);
        this.aEO = new o(this);
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

    public void a(List<com.baidu.tbadk.widget.a.g> list, TbPageContext<?> tbPageContext, boolean z) {
        if (x.o(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            if (z) {
                list.add(new com.baidu.tbadk.widget.a.g());
            }
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
                com.baidu.tbadk.widget.a.g gVar = (com.baidu.tbadk.widget.a.g) com.baidu.tbadk.core.util.x.b(list, i2);
                a aVar2 = (a) com.baidu.tbadk.core.util.x.b(this.aEG, i2);
                if (aVar2 != null) {
                    b(aVar2.getView(), gVar);
                } else {
                    View ni = ni();
                    if (ni != null) {
                        a aVar3 = new a(ni);
                        this.aEG.add(aVar3);
                        b(aVar3.getView(), gVar);
                        this.aEF.addView(ni);
                    }
                }
                if (i2 == o2 - 1 && z) {
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

    private void a(a aVar) {
        if (aVar != null) {
            this.aEI = aVar.getView();
            aVar.aEW.setVisibility(8);
            aVar.aEU.setText(this.mTbPageContext.getPageActivity().getResources().getString(t.j.recommend_frs_hot_thread_more));
            aVar.aET.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ar.c(aVar.aET, t.f.icon_pic_more);
            ar.b(aVar.aEU, t.d.cp_cont_b, 1);
            ar.k(aVar.aET, t.f.selector_load_more_bg);
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

    private void a(View view, com.baidu.tbadk.widget.a.g gVar) {
        if (view != null && view.getTag() != null && gVar != null) {
            a aVar = (a) view.getTag();
            aVar.aEW.setClickable(true);
            aVar.aEW.setOnClickListener(this.aEN);
            view.setClickable(true);
            view.setOnClickListener(this.aEO);
        }
    }

    private View ni() {
        return View.inflate(this.mTbPageContext.getPageActivity(), t.h.extend_forum_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.a.g gVar) {
        if (gVar != null && view != null && view.getTag() != null) {
            a aVar = (a) view.getTag();
            aVar.aET.setTag(gVar.forumAvatar);
            aVar.aET.d(gVar.forumAvatar, 10, false);
            aVar.aEU.setText(E(gVar.forumName, 8));
            aVar.aEU.setTag(t.g.tag_forum_id, Long.valueOf(gVar.forumId));
            aVar.aEW.setTag(t.g.tag_forum_id, Long.valueOf(gVar.forumId));
            aVar.aEW.setTag(t.g.tag_forum_name, gVar.forumName);
            aVar.getView().setTag(t.g.tag_forum_id, Long.valueOf(gVar.forumId));
            aVar.getView().setTag(t.g.tag_forum_name, gVar.forumName);
            a(aVar.aEW, gVar.isLiked);
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
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        ar.b(textView, t.d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.m411getInst().getString(t.j.forum_list_attention_tv));
        ar.k(textView, t.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds18), 0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds10), 0);
    }

    public void db(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.aEG.iterator();
            while (it.hasNext()) {
                a next = it.next();
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
            this.mSkinType = i;
        }
    }

    private void a(a aVar, int i) {
        if (aVar != null && aVar.getView() != null) {
            if (aVar.aEW.getTag(t.g.forum_follow) != null && (aVar.aEW.getTag(t.g.forum_follow) instanceof Boolean)) {
                a(aVar.aEW, ((Boolean) aVar.aEW.getTag(t.g.forum_follow)).booleanValue());
            }
            ar.b(aVar.aEU, t.d.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, boolean z) {
        Iterator<a> it = this.aEG.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.aEU.getTag(t.g.tag_forum_id) != null) {
                TextView textView = next.aEW;
                if (((Long) next.aEU.getTag(t.g.tag_forum_id)).longValue() == j) {
                    a(textView, z);
                    return;
                }
            }
        }
    }

    private String E(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > i) {
            String substring = str.substring(0, i - 1);
            if (this.mTbPageContext != null) {
                substring = String.valueOf(substring) + this.mTbPageContext.getString(t.j.topic_end);
            }
            return substring;
        }
        return str;
    }

    /* loaded from: classes.dex */
    public static class a extends x.a {
        public BarImageView aET;
        public TextView aEU;
        public TextView aEW;

        public a(View view) {
            super(view);
            this.aET = null;
            this.aEU = null;
            this.aEW = null;
            this.aET = (BarImageView) view.findViewById(t.g.forum_avatar);
            this.aET.setGifIconSupport(false);
            this.aEU = (TextView) view.findViewById(t.g.m_forum_name_textview);
            this.aEW = (TextView) view.findViewById(t.g.forum_add_love);
        }
    }
}
