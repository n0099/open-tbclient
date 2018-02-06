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
    private LikeModel cdg;
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
                                i.this.cdg.cc(jVar.getForumName(), forumId);
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
        if (this.cdg == null) {
            Xy();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(d.h.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, kVar);
        if (jVar != null && jVar.atU() != null) {
            int color = aj.getColor(d.C0140d.cp_other_b);
            int color2 = aj.getColor(d.C0140d.cp_cont_b);
            r atU = jVar.atU();
            boolean isLogin = TbadkCoreApplication.isLogin();
            if (atU.isLike() == 1 && isLogin) {
                kVar.dBG.setVisibility(8);
                kVar.dBH.setText(d.j.degree);
                aj.c(kVar.dAJ, BitmapHelper.getSmallGradeResourceIdNew(atU.btq()));
                if (StringUtils.isNull(atU.getLevelName())) {
                    kVar.dAK.setVisibility(8);
                } else {
                    kVar.dAK.setText(atU.getLevelName());
                    kVar.dAK.setVisibility(0);
                }
            } else {
                kVar.dBG.setVisibility(0);
                kVar.dBH.setText(d.j.tbtille_just_be);
                aj.c(kVar.dAJ, BitmapHelper.getSmallGradeResourceIdNew(atU.btq()));
                kVar.dAK.setVisibility(8);
            }
            kVar.dBG.setTag(Integer.valueOf(i));
            kVar.dBI.setTag(Integer.valueOf(i));
            if (!isLogin) {
                kVar.chX.setVisibility(8);
                kVar.dBJ.setVisibility(8);
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(atU.getCurScore() + "");
                spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 17);
                SpannableString spannableString2 = new SpannableString("/" + atU.getLevelupScore());
                spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 17);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) spannableString2);
                kVar.dBK.setText(spannableStringBuilder);
                kVar.chX.setVisibility(0);
                kVar.dBJ.setVisibility(0);
            }
            aj.t(kVar.dBL, d.C0140d.cp_bg_line_d);
            aj.t(kVar.dBM, d.C0140d.cp_bg_line_c);
            aj.t(kVar.dBN, d.C0140d.cp_bg_line_b);
            aj.t(kVar.chX, d.C0140d.cp_bg_line_b);
            aj.t(kVar.dBO, d.C0140d.cp_bg_line_c);
            aj.s(kVar.dBG, d.f.frs_btn_like);
            aj.s(kVar.dAK, d.f.bg_bawu_level_title);
            aj.e(kVar.dBP, d.C0140d.cp_cont_c, 1);
            aj.e(kVar.dBI, d.C0140d.cp_cont_d, 1);
            kVar.dBI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
            aj.e(kVar.dBG, d.C0140d.white_alpha100, 1);
            aj.e(kVar.dBH, d.C0140d.cp_cont_b, 1);
            aj.e(kVar.dAK, d.C0140d.cp_cont_c, 1);
            aj.e(kVar.dBQ, d.C0140d.cp_cont_b, 1);
        }
        return view;
    }

    private void Xy() {
        if (this.mPageContext != null) {
            this.cdg = new LikeModel(this.mPageContext);
            this.cdg.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void ak(Object obj) {
                    if (!(obj instanceof r) || i.this.cdg.getErrorCode() != 0) {
                        if (AntiHelper.vQ(i.this.cdg.getErrorCode())) {
                            AntiHelper.ar(i.this.mPageContext.getPageActivity(), i.this.cdg.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.cdg.getErrorString());
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
