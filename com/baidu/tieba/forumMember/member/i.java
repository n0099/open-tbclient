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
import com.baidu.tieba.f;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.frs.h<j, k> {
    private LikeModel azn;
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
                        if (view.getId() == f.g.like_btn) {
                            if (bb.aU(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.jE()) {
                                    i.this.mPageContext.showToast(f.j.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.azn.ck(jVar.getForumName(), forumId);
                            }
                        } else if (view.getId() == f.g.detail_tip_view) {
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
    /* renamed from: aj */
    public k onCreateViewHolder(ViewGroup viewGroup) {
        if (this.azn == null) {
            TY();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(f.h.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, kVar);
        if (jVar != null && jVar.atb() != null) {
            int color = am.getColor(f.d.cp_other_b);
            int color2 = am.getColor(f.d.cp_cont_b);
            r atb = jVar.atb();
            boolean isLogin = TbadkCoreApplication.isLogin();
            if (atb.isLike() == 1 && isLogin) {
                kVar.dje.setVisibility(8);
                kVar.djf.setText(f.j.degree);
                am.c(kVar.dif, BitmapHelper.getSmallGradeResourceIdNew(atb.bsB()));
                if (StringUtils.isNull(atb.getLevelName())) {
                    kVar.dig.setVisibility(8);
                } else {
                    kVar.dig.setText(atb.getLevelName());
                    kVar.dig.setVisibility(0);
                }
            } else {
                kVar.dje.setVisibility(0);
                kVar.djf.setText(f.j.tbtille_just_be);
                am.c(kVar.dif, BitmapHelper.getSmallGradeResourceIdNew(atb.bsB()));
                kVar.dig.setVisibility(8);
            }
            kVar.dje.setTag(Integer.valueOf(i));
            kVar.djg.setTag(Integer.valueOf(i));
            if (!isLogin) {
                kVar.bHR.setVisibility(8);
                kVar.djh.setVisibility(8);
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(atb.getCurScore() + "");
                spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 17);
                SpannableString spannableString2 = new SpannableString("/" + atb.getLevelupScore());
                spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 17);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) spannableString2);
                kVar.dji.setText(spannableStringBuilder);
                kVar.bHR.setVisibility(0);
                kVar.djh.setVisibility(0);
            }
            am.j(kVar.djj, f.d.cp_bg_line_d);
            am.j(kVar.djk, f.d.cp_bg_line_c);
            am.j(kVar.djl, f.d.cp_bg_line_b);
            am.j(kVar.bHR, f.d.cp_bg_line_b);
            am.j(kVar.djm, f.d.cp_bg_line_c);
            am.i(kVar.dje, f.C0146f.frs_btn_like);
            am.i(kVar.dig, f.C0146f.bg_bawu_level_title);
            am.c(kVar.djn, f.d.cp_cont_c, 1);
            am.c(kVar.djg, f.d.cp_cont_d, 1);
            kVar.djg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(f.C0146f.icon_arrow_tab), (Drawable) null);
            am.c(kVar.dje, f.d.white_alpha100, 1);
            am.c(kVar.djf, f.d.cp_cont_b, 1);
            am.c(kVar.dig, f.d.cp_cont_c, 1);
            am.c(kVar.djo, f.d.cp_cont_b, 1);
        }
        return view;
    }

    private void TY() {
        if (this.mPageContext != null) {
            this.azn = new LikeModel(this.mPageContext);
            this.azn.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void i(Object obj) {
                    if (!(obj instanceof r) || i.this.azn.getErrorCode() != 0) {
                        if (AntiHelper.al(i.this.azn.getErrorCode(), i.this.azn.getErrorString())) {
                            AntiHelper.aq(i.this.mPageContext.getPageActivity(), i.this.azn.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.azn.getErrorString());
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
