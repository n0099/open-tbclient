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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.frs.h<j, k> {
    private LikeModel azq;
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
                            if (ba.aV(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.jE()) {
                                    i.this.mPageContext.showToast(d.j.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.azq.ck(jVar.getForumName(), forumId);
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
    /* renamed from: aj */
    public k onCreateViewHolder(ViewGroup viewGroup) {
        if (this.azq == null) {
            TV();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(d.h.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, kVar);
        if (jVar != null && jVar.atc() != null) {
            int color = am.getColor(d.C0140d.cp_other_b);
            int color2 = am.getColor(d.C0140d.cp_cont_b);
            r atc = jVar.atc();
            boolean isLogin = TbadkCoreApplication.isLogin();
            if (atc.isLike() == 1 && isLogin) {
                kVar.djg.setVisibility(8);
                kVar.djh.setText(d.j.degree);
                am.c(kVar.dih, BitmapHelper.getSmallGradeResourceIdNew(atc.bsA()));
                if (StringUtils.isNull(atc.getLevelName())) {
                    kVar.dii.setVisibility(8);
                } else {
                    kVar.dii.setText(atc.getLevelName());
                    kVar.dii.setVisibility(0);
                }
            } else {
                kVar.djg.setVisibility(0);
                kVar.djh.setText(d.j.tbtille_just_be);
                am.c(kVar.dih, BitmapHelper.getSmallGradeResourceIdNew(atc.bsA()));
                kVar.dii.setVisibility(8);
            }
            kVar.djg.setTag(Integer.valueOf(i));
            kVar.dji.setTag(Integer.valueOf(i));
            if (!isLogin) {
                kVar.bHR.setVisibility(8);
                kVar.djj.setVisibility(8);
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(atc.getCurScore() + "");
                spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 17);
                SpannableString spannableString2 = new SpannableString("/" + atc.getLevelupScore());
                spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 17);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) spannableString2);
                kVar.djk.setText(spannableStringBuilder);
                kVar.bHR.setVisibility(0);
                kVar.djj.setVisibility(0);
            }
            am.j(kVar.djl, d.C0140d.cp_bg_line_d);
            am.j(kVar.djm, d.C0140d.cp_bg_line_c);
            am.j(kVar.djn, d.C0140d.cp_bg_line_b);
            am.j(kVar.bHR, d.C0140d.cp_bg_line_b);
            am.j(kVar.djo, d.C0140d.cp_bg_line_c);
            am.i(kVar.djg, d.f.frs_btn_like);
            am.i(kVar.dii, d.f.bg_bawu_level_title);
            am.c(kVar.djp, d.C0140d.cp_cont_c, 1);
            am.c(kVar.dji, d.C0140d.cp_cont_d, 1);
            kVar.dji.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
            am.c(kVar.djg, d.C0140d.white_alpha100, 1);
            am.c(kVar.djh, d.C0140d.cp_cont_b, 1);
            am.c(kVar.dii, d.C0140d.cp_cont_c, 1);
            am.c(kVar.djq, d.C0140d.cp_cont_b, 1);
        }
        return view;
    }

    private void TV() {
        if (this.mPageContext != null) {
            this.azq = new LikeModel(this.mPageContext);
            this.azq.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void i(Object obj) {
                    if (!(obj instanceof r) || i.this.azq.getErrorCode() != 0) {
                        if (AntiHelper.al(i.this.azq.getErrorCode(), i.this.azq.getErrorString())) {
                            AntiHelper.aq(i.this.mPageContext.getPageActivity(), i.this.azq.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.azq.getErrorString());
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
