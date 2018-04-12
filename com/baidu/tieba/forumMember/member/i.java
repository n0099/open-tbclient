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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.frs.f<j, k> {
    private LikeModel bmW;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.h item = i.this.getItem(((Integer) tag).intValue());
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (view2.getId() == d.g.like_btn) {
                            if (az.aK(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.gP()) {
                                    i.this.mPageContext.showToast(d.k.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.bmW.cb(jVar.getForumName(), forumId);
                            }
                        } else if (view2.getId() == d.g.detail_tip_view) {
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
        if (this.bmW == null) {
            PY();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(d.i.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, j jVar, k kVar) {
        super.onFillViewHolder(i, view2, viewGroup, jVar, kVar);
        if (jVar != null && jVar.aoj() != null) {
            int color = ak.getColor(d.C0126d.cp_other_b);
            int color2 = ak.getColor(d.C0126d.cp_cont_b);
            r aoj = jVar.aoj();
            boolean isLogin = TbadkCoreApplication.isLogin();
            if (aoj.isLike() == 1 && isLogin) {
                kVar.cUj.setVisibility(8);
                kVar.cUk.setText(d.k.degree);
                ak.c(kVar.cTm, BitmapHelper.getSmallGradeResourceIdNew(aoj.boz()));
                if (StringUtils.isNull(aoj.getLevelName())) {
                    kVar.cTn.setVisibility(8);
                } else {
                    kVar.cTn.setText(aoj.getLevelName());
                    kVar.cTn.setVisibility(0);
                }
            } else {
                kVar.cUj.setVisibility(0);
                kVar.cUk.setText(d.k.tbtille_just_be);
                ak.c(kVar.cTm, BitmapHelper.getSmallGradeResourceIdNew(aoj.boz()));
                kVar.cTn.setVisibility(8);
            }
            kVar.cUj.setTag(Integer.valueOf(i));
            kVar.cUl.setTag(Integer.valueOf(i));
            if (!isLogin) {
                kVar.bwn.setVisibility(8);
                kVar.cUm.setVisibility(8);
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(aoj.getCurScore() + "");
                spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 17);
                SpannableString spannableString2 = new SpannableString("/" + aoj.getLevelupScore());
                spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 17);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) spannableString2);
                kVar.cUn.setText(spannableStringBuilder);
                kVar.bwn.setVisibility(0);
                kVar.cUm.setVisibility(0);
            }
            ak.j(kVar.cUo, d.C0126d.cp_bg_line_d);
            ak.j(kVar.cUp, d.C0126d.cp_bg_line_c);
            ak.j(kVar.cUq, d.C0126d.cp_bg_line_b);
            ak.j(kVar.bwn, d.C0126d.cp_bg_line_b);
            ak.j(kVar.cUr, d.C0126d.cp_bg_line_c);
            ak.i(kVar.cUj, d.f.frs_btn_like);
            ak.i(kVar.cTn, d.f.bg_bawu_level_title);
            ak.c(kVar.cUs, d.C0126d.cp_cont_c, 1);
            ak.c(kVar.cUl, d.C0126d.cp_cont_d, 1);
            kVar.cUl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
            ak.c(kVar.cUj, d.C0126d.white_alpha100, 1);
            ak.c(kVar.cUk, d.C0126d.cp_cont_b, 1);
            ak.c(kVar.cTn, d.C0126d.cp_cont_c, 1);
            ak.c(kVar.cUt, d.C0126d.cp_cont_b, 1);
        }
        return view2;
    }

    private void PY() {
        if (this.mPageContext != null) {
            this.bmW = new LikeModel(this.mPageContext);
            this.bmW.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void f(Object obj) {
                    if (!(obj instanceof r) || i.this.bmW.getErrorCode() != 0) {
                        if (AntiHelper.tu(i.this.bmW.getErrorCode())) {
                            AntiHelper.am(i.this.mPageContext.getPageActivity(), i.this.bmW.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.bmW.getErrorString());
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
