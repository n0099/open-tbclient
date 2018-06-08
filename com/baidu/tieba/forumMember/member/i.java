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
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.frs.f<j, k> {
    private LikeModel bvr;
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
                            if (ba.aU(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.jD()) {
                                    i.this.mPageContext.showToast(d.k.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.bvr.cj(jVar.getForumName(), forumId);
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
    /* renamed from: ak */
    public k onCreateViewHolder(ViewGroup viewGroup) {
        if (this.bvr == null) {
            Tt();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(d.i.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, kVar);
        if (jVar != null && jVar.asn() != null) {
            int color = al.getColor(d.C0141d.cp_other_b);
            int color2 = al.getColor(d.C0141d.cp_cont_b);
            r asn = jVar.asn();
            boolean isLogin = TbadkCoreApplication.isLogin();
            if (asn.isLike() == 1 && isLogin) {
                kVar.dez.setVisibility(8);
                kVar.deA.setText(d.k.degree);
                al.c(kVar.ddz, BitmapHelper.getSmallGradeResourceIdNew(asn.btx()));
                if (StringUtils.isNull(asn.getLevelName())) {
                    kVar.ddA.setVisibility(8);
                } else {
                    kVar.ddA.setText(asn.getLevelName());
                    kVar.ddA.setVisibility(0);
                }
            } else {
                kVar.dez.setVisibility(0);
                kVar.deA.setText(d.k.tbtille_just_be);
                al.c(kVar.ddz, BitmapHelper.getSmallGradeResourceIdNew(asn.btx()));
                kVar.ddA.setVisibility(8);
            }
            kVar.dez.setTag(Integer.valueOf(i));
            kVar.deB.setTag(Integer.valueOf(i));
            if (!isLogin) {
                kVar.bFh.setVisibility(8);
                kVar.deC.setVisibility(8);
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(asn.getCurScore() + "");
                spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 17);
                SpannableString spannableString2 = new SpannableString("/" + asn.getLevelupScore());
                spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 17);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) spannableString2);
                kVar.deD.setText(spannableStringBuilder);
                kVar.bFh.setVisibility(0);
                kVar.deC.setVisibility(0);
            }
            al.j(kVar.deE, d.C0141d.cp_bg_line_d);
            al.j(kVar.deF, d.C0141d.cp_bg_line_c);
            al.j(kVar.deG, d.C0141d.cp_bg_line_b);
            al.j(kVar.bFh, d.C0141d.cp_bg_line_b);
            al.j(kVar.deH, d.C0141d.cp_bg_line_c);
            al.i(kVar.dez, d.f.frs_btn_like);
            al.i(kVar.ddA, d.f.bg_bawu_level_title);
            al.c(kVar.deI, d.C0141d.cp_cont_c, 1);
            al.c(kVar.deB, d.C0141d.cp_cont_d, 1);
            kVar.deB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
            al.c(kVar.dez, d.C0141d.white_alpha100, 1);
            al.c(kVar.deA, d.C0141d.cp_cont_b, 1);
            al.c(kVar.ddA, d.C0141d.cp_cont_c, 1);
            al.c(kVar.deJ, d.C0141d.cp_cont_b, 1);
        }
        return view;
    }

    private void Tt() {
        if (this.mPageContext != null) {
            this.bvr = new LikeModel(this.mPageContext);
            this.bvr.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void i(Object obj) {
                    if (!(obj instanceof r) || i.this.bvr.getErrorCode() != 0) {
                        if (AntiHelper.tE(i.this.bvr.getErrorCode())) {
                            AntiHelper.ao(i.this.mPageContext.getPageActivity(), i.this.bvr.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.bvr.getErrorString());
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
