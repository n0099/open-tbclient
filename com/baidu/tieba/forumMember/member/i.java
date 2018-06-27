package com.baidu.tieba.forumMember.member;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.frs.h<j, k> {
    private LikeModel bwM;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.h item = i.this.getItem(((Integer) tag).intValue());
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (view.getId() == d.g.like_btn) {
                            if (bb.aU(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.jD()) {
                                    i.this.mPageContext.showToast(d.k.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.bwM.cn(jVar.getForumName(), forumId);
                            }
                        } else if (view.getId() == d.g.detail_tip_view) {
                            String forumId2 = jVar.getForumId();
                            i.this.mPageContext.sendMessage(new CustomMessage(2003006, new TbTitleActivityConfig(i.this.mContext, jVar.getForumName(), forumId2)));
                        }
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ai */
    public k onCreateViewHolder(ViewGroup viewGroup) {
        if (this.bwM == null) {
            TN();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(d.i.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, kVar);
        if (jVar != null && jVar.asy() != null) {
            int color = am.getColor(d.C0142d.cp_other_b);
            int color2 = am.getColor(d.C0142d.cp_cont_b);
            r asy = jVar.asy();
            boolean isLogin = TbadkCoreApplication.isLogin();
            if (asy.isLike() == 1 && isLogin) {
                kVar.dgq.setVisibility(8);
                kVar.dgr.setText(d.k.degree);
                am.c(kVar.dfr, BitmapHelper.getSmallGradeResourceIdNew(asy.btX()));
                if (StringUtils.isNull(asy.getLevelName())) {
                    kVar.dfs.setVisibility(8);
                } else {
                    kVar.dfs.setText(asy.getLevelName());
                    kVar.dfs.setVisibility(0);
                }
            } else {
                kVar.dgq.setVisibility(0);
                kVar.dgr.setText(d.k.tbtille_just_be);
                am.c(kVar.dfr, BitmapHelper.getSmallGradeResourceIdNew(asy.btX()));
                kVar.dfs.setVisibility(8);
            }
            kVar.dgq.setTag(Integer.valueOf(i));
            kVar.dgs.setTag(Integer.valueOf(i));
            if (!isLogin) {
                kVar.bHc.setVisibility(8);
                kVar.dgt.setVisibility(8);
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(asy.getCurScore() + "");
                spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 17);
                SpannableString spannableString2 = new SpannableString("/" + asy.getLevelupScore());
                spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 17);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) spannableString2);
                kVar.dgu.setText(spannableStringBuilder);
                kVar.bHc.setVisibility(0);
                kVar.dgt.setVisibility(0);
            }
            am.j(kVar.dgv, d.C0142d.cp_bg_line_d);
            am.j(kVar.dgw, d.C0142d.cp_bg_line_c);
            am.j(kVar.dgx, d.C0142d.cp_bg_line_b);
            am.j(kVar.bHc, d.C0142d.cp_bg_line_b);
            am.j(kVar.dgy, d.C0142d.cp_bg_line_c);
            am.i(kVar.dgq, d.f.frs_btn_like);
            am.i(kVar.dfs, d.f.bg_bawu_level_title);
            am.c(kVar.dgz, d.C0142d.cp_cont_c, 1);
            am.c(kVar.dgs, d.C0142d.cp_cont_d, 1);
            kVar.dgs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
            am.c(kVar.dgq, d.C0142d.white_alpha100, 1);
            am.c(kVar.dgr, d.C0142d.cp_cont_b, 1);
            am.c(kVar.dfs, d.C0142d.cp_cont_c, 1);
            am.c(kVar.dgA, d.C0142d.cp_cont_b, 1);
        }
        return view;
    }

    private void TN() {
        if (this.mPageContext != null) {
            this.bwM = new LikeModel(this.mPageContext);
            this.bwM.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void i(Object obj) {
                    if (!(obj instanceof r) || i.this.bwM.getErrorCode() != 0) {
                        if (AntiHelper.tQ(i.this.bwM.getErrorCode())) {
                            AntiHelper.ao(i.this.mPageContext.getPageActivity(), i.this.bwM.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.bwM.getErrorString());
                            return;
                        }
                    }
                    r rVar = (r) obj;
                    rVar.setLike(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                }
            });
        }
    }
}
