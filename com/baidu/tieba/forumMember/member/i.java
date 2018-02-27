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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.frs.g<j, k> {
    private LikeModel ccU;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.i item = i.this.getItem(((Integer) tag).intValue());
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (view.getId() == d.g.like_btn) {
                            if (ay.ba(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.oJ()) {
                                    i.this.mPageContext.showToast(d.j.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.ccU.cc(jVar.getForumName(), forumId);
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
    /* renamed from: ao */
    public k onCreateViewHolder(ViewGroup viewGroup) {
        if (this.ccU == null) {
            Xx();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(d.h.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, kVar);
        if (jVar != null && jVar.atT() != null) {
            int color = aj.getColor(d.C0141d.cp_other_b);
            int color2 = aj.getColor(d.C0141d.cp_cont_b);
            r atT = jVar.atT();
            boolean isLogin = TbadkCoreApplication.isLogin();
            if (atT.isLike() == 1 && isLogin) {
                kVar.dBu.setVisibility(8);
                kVar.dBv.setText(d.j.degree);
                aj.c(kVar.dAx, BitmapHelper.getSmallGradeResourceIdNew(atT.btp()));
                if (StringUtils.isNull(atT.getLevelName())) {
                    kVar.dAy.setVisibility(8);
                } else {
                    kVar.dAy.setText(atT.getLevelName());
                    kVar.dAy.setVisibility(0);
                }
            } else {
                kVar.dBu.setVisibility(0);
                kVar.dBv.setText(d.j.tbtille_just_be);
                aj.c(kVar.dAx, BitmapHelper.getSmallGradeResourceIdNew(atT.btp()));
                kVar.dAy.setVisibility(8);
            }
            kVar.dBu.setTag(Integer.valueOf(i));
            kVar.dBw.setTag(Integer.valueOf(i));
            if (!isLogin) {
                kVar.chL.setVisibility(8);
                kVar.dBx.setVisibility(8);
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(atT.getCurScore() + "");
                spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 17);
                SpannableString spannableString2 = new SpannableString("/" + atT.getLevelupScore());
                spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 17);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) spannableString2);
                kVar.dBy.setText(spannableStringBuilder);
                kVar.chL.setVisibility(0);
                kVar.dBx.setVisibility(0);
            }
            aj.t(kVar.dBz, d.C0141d.cp_bg_line_d);
            aj.t(kVar.dBA, d.C0141d.cp_bg_line_c);
            aj.t(kVar.dBB, d.C0141d.cp_bg_line_b);
            aj.t(kVar.chL, d.C0141d.cp_bg_line_b);
            aj.t(kVar.dBC, d.C0141d.cp_bg_line_c);
            aj.s(kVar.dBu, d.f.frs_btn_like);
            aj.s(kVar.dAy, d.f.bg_bawu_level_title);
            aj.e(kVar.dBD, d.C0141d.cp_cont_c, 1);
            aj.e(kVar.dBw, d.C0141d.cp_cont_d, 1);
            kVar.dBw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
            aj.e(kVar.dBu, d.C0141d.white_alpha100, 1);
            aj.e(kVar.dBv, d.C0141d.cp_cont_b, 1);
            aj.e(kVar.dAy, d.C0141d.cp_cont_c, 1);
            aj.e(kVar.dBE, d.C0141d.cp_cont_b, 1);
        }
        return view;
    }

    private void Xx() {
        if (this.mPageContext != null) {
            this.ccU = new LikeModel(this.mPageContext);
            this.ccU.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void ak(Object obj) {
                    if (!(obj instanceof r) || i.this.ccU.getErrorCode() != 0) {
                        if (AntiHelper.vR(i.this.ccU.getErrorCode())) {
                            AntiHelper.ar(i.this.mPageContext.getPageActivity(), i.this.ccU.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.ccU.getErrorString());
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
