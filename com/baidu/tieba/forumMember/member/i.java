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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.e;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.frs.h<j, k> {
    private LikeModel aLn;
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
                        if (view.getId() == e.g.like_btn) {
                            if (ba.bJ(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.kV()) {
                                    i.this.mPageContext.showToast(e.j.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.aLn.cK(jVar.getForumName(), forumId);
                            }
                        } else if (view.getId() == e.g.detail_tip_view) {
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
    /* renamed from: al */
    public k onCreateViewHolder(ViewGroup viewGroup) {
        if (this.aLn == null) {
            aaL();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(e.h.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, kVar);
        if (jVar != null && jVar.aAi() != null) {
            int color = al.getColor(e.d.cp_other_b);
            int color2 = al.getColor(e.d.cp_cont_b);
            r aAi = jVar.aAi();
            boolean isLogin = TbadkCoreApplication.isLogin();
            if (aAi.isLike() == 1 && isLogin) {
                kVar.dHE.setVisibility(8);
                kVar.dHF.setText(e.j.degree);
                al.c(kVar.dGF, BitmapHelper.getSmallGradeResourceIdNew(aAi.bAA()));
                if (StringUtils.isNull(aAi.getLevelName())) {
                    kVar.dGG.setVisibility(8);
                } else {
                    kVar.dGG.setText(aAi.getLevelName());
                    kVar.dGG.setVisibility(0);
                }
            } else {
                kVar.dHE.setVisibility(0);
                kVar.dHF.setText(e.j.tbtille_just_be);
                al.c(kVar.dGF, BitmapHelper.getSmallGradeResourceIdNew(aAi.bAA()));
                kVar.dGG.setVisibility(8);
            }
            kVar.dHE.setTag(Integer.valueOf(i));
            kVar.dHG.setTag(Integer.valueOf(i));
            if (!isLogin) {
                kVar.mDivider.setVisibility(8);
                kVar.dHH.setVisibility(8);
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(aAi.getCurScore() + "");
                spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 17);
                SpannableString spannableString2 = new SpannableString("/" + aAi.getLevelupScore());
                spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 17);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) spannableString2);
                kVar.dHI.setText(spannableStringBuilder);
                kVar.mDivider.setVisibility(0);
                kVar.dHH.setVisibility(0);
            }
            al.j(kVar.dHJ, e.d.cp_bg_line_d);
            al.j(kVar.dHK, e.d.cp_bg_line_c);
            al.j(kVar.dHL, e.d.cp_bg_line_b);
            al.j(kVar.mDivider, e.d.cp_bg_line_b);
            al.j(kVar.dHM, e.d.cp_bg_line_c);
            al.i(kVar.dHE, e.f.frs_btn_like);
            al.i(kVar.dGG, e.f.bg_bawu_level_title);
            al.c(kVar.dHN, e.d.cp_cont_c, 1);
            al.c(kVar.dHG, e.d.cp_cont_d, 1);
            kVar.dHG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_tab), (Drawable) null);
            al.c(kVar.dHE, e.d.white_alpha100, 1);
            al.c(kVar.dHF, e.d.cp_cont_b, 1);
            al.c(kVar.dGG, e.d.cp_cont_c, 1);
            al.c(kVar.dHO, e.d.cp_cont_b, 1);
        }
        return view;
    }

    private void aaL() {
        if (this.mPageContext != null) {
            this.aLn = new LikeModel(this.mPageContext);
            this.aLn.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (!(obj instanceof r) || i.this.aLn.getErrorCode() != 0) {
                        if (AntiHelper.aj(i.this.aLn.getErrorCode(), i.this.aLn.getErrorString())) {
                            AntiHelper.aJ(i.this.mPageContext.getPageActivity(), i.this.aLn.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.aLn.getErrorString());
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
