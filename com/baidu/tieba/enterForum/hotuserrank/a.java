package com.baidu.tieba.enterForum.hotuserrank;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.tieba.view.IrregularImageView;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes9.dex */
public class a {
    private TextView gCc;
    private TextView gCd;
    private TextView gCe;
    private ImageView gCf;
    private ImageView gCg;
    private ImageView gCh;
    private ImageView gCi;
    private ImageView gCj;
    private IrregularImageView gCk;
    private TextView gCl;
    private RelativeLayout gCm;
    private ImageView gCn;
    private TextView gCo;
    private ImageOverlayView gCp;
    private ImageView gCq;
    private ImageView gCr;
    private String gCs;
    private com.baidu.tieba.enterForum.hotuserrank.a.a gCt;
    private View gzr;
    private final String mCategory;
    private final long mForumId;
    private View mRootView;
    private int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.gzr.getId() && a.this.gCt != null && a.this.gCt.gDq != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.mRootView.getContext(), a.this.gCt.gDq.getUserId(), a.this.gCt.gDq.getName_show())));
                if (!TextUtils.isEmpty(a.this.mCategory)) {
                    an anVar = new an("c13659");
                    anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.cI("resource_id", a.this.gCt.gDo);
                    anVar.cI("friend_uid", a.this.gCt.gDq.rankNum);
                    TiebaStatic.log(anVar);
                    return;
                }
                an anVar2 = new an("c13683");
                anVar2.cI("uid", a.this.gCt.gDq.getUserId());
                anVar2.t("fid", a.this.mForumId);
                TiebaStatic.log(anVar2);
            }
        }
    };

    public a(View view, String str, long j) {
        this.mRootView = view;
        this.mCategory = str;
        this.mForumId = j;
        this.gzr = view.findViewById(R.id.top_container);
        this.gzr.setOnClickListener(this.mOnClickListener);
        this.gCc = (TextView) view.findViewById(R.id.rank_name);
        this.gCc.getPaint().setFakeBoldText(true);
        this.gCd = (TextView) view.findViewById(R.id.top_user_name);
        this.gCe = (TextView) view.findViewById(R.id.rank_data);
        this.gCf = (ImageView) view.findViewById(R.id.img_left_top_cover);
        this.gCg = (ImageView) view.findViewById(R.id.img_left_bottom_cover);
        this.gCh = (ImageView) view.findViewById(R.id.img_center_top_cover);
        this.gCi = (ImageView) view.findViewById(R.id.img_right_top_cover);
        this.gCj = (ImageView) view.findViewById(R.id.img_right_bottom_cover);
        this.gCk = (IrregularImageView) view.findViewById(R.id.img_user_head);
        this.gCk.setErrorRes(R.drawable.pic_list_avatar);
        this.gCf.setImageDrawable(SvgManager.aOU().i(R.drawable.svg_pic_mask_rule_line100, 1, false));
        this.gCg.setImageDrawable(SvgManager.aOU().i(R.drawable.svg_pic_mask_list_circle, 1, false));
        this.gCh.setImageDrawable(SvgManager.aOU().i(R.drawable.svg_pic_mask_list_line, 1, false));
        this.gCi.setImageDrawable(SvgManager.aOU().i(R.drawable.svg_pic_mask_list_circle2, 1, false));
        this.gCj.setImageDrawable(SvgManager.aOU().i(R.drawable.svg_pic_mask_list_line2, 1, false));
        this.gCl = (TextView) view.findViewById(R.id.text_compute_method);
        this.gCl.setText(this.mRootView.getResources().getString(R.string.hot_user_rank_influence_desc));
        this.gCm = (RelativeLayout) view.findViewById(R.id.hot_rank_entry);
        this.gCm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.mForumId > 0) {
                    an anVar = new an("c13671");
                    anVar.t("fid", a.this.mForumId);
                    TiebaStatic.log(anVar);
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(a.this.mRootView.getContext());
                hotUserRankActivityConfig.setCategory(a.this.gCs);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            }
        });
        this.gCn = (ImageView) view.findViewById(R.id.hot_rank_entry_crown);
        this.gCo = (TextView) view.findViewById(R.id.hot_rank_entry_describe);
        this.gCr = (ImageView) view.findViewById(R.id.hot_rank_entry_first_tag);
        this.gCp = (ImageOverlayView) view.findViewById(R.id.hot_rank_entry_image_group);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.gCp.k(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.cp_mask_c_alpha50, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.gCp.setStrokeStyle(1);
        this.gCp.setFirstImageStrokeColor(R.color.cp_other_h);
        this.gCp.setLoadImageType(12);
        this.gCq = (ImageView) view.findViewById(R.id.hot_rank_entry_arrow);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.gCt = aVar;
        if (aVar != null) {
            this.gCc.setText(aVar.gDo);
            if (aVar.gDq != null) {
                this.gCd.setText(String.format(this.mRootView.getContext().getResources().getString(R.string.hot_user_rank_top_name), aq.ag(aVar.gDp, 10)));
            }
            if (aVar.gDr == 0) {
                this.gCe.setVisibility(8);
            } else {
                this.gCe.setVisibility(0);
                this.gCe.setText(String.format(this.mRootView.getContext().getString(R.string.hot_user_rank_data), aq.ch(aVar.gDr * 1000)));
            }
            this.gCk.setImage(aVar.gDs, eC(this.mRootView.getContext()), R.drawable.mask_list_avatar);
            if (aVar.gDt != null && !z && !TextUtils.isEmpty(aVar.gDt.tieba_name)) {
                this.gCm.setVisibility(0);
                this.gCo.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), aVar.gDt.tieba_name));
                List<String> bW = bW(aVar.gDt.user_rank);
                this.gCp.setData(bW);
                bX(bW);
                this.gCs = aVar.gDt.tieba_name;
                if (this.mForumId > 0) {
                    an anVar = new an("c13670");
                    anVar.t("fid", this.mForumId);
                    TiebaStatic.log(anVar);
                    return;
                }
                return;
            }
            this.gCm.setVisibility(8);
        }
    }

    private List<String> bW(List<User> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (User user : list) {
            if (user != null) {
                arrayList.add(user.portrait);
            }
        }
        return arrayList;
    }

    private void bX(List<String> list) {
        int count = v.getCount(list);
        if (count == 0) {
            this.gCr.setVisibility(8);
            return;
        }
        this.gCr.setVisibility(0);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
        if (count < 3) {
            int dimensionPixelOffset2 = dimensionPixelOffset - ((3 - count) * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gCr.getLayoutParams();
            layoutParams.rightMargin = dimensionPixelOffset2;
            this.gCr.setLayoutParams(layoutParams);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.gCl, (int) R.color.cp_cont_d);
            SvgManager.aOU().a(this.gCn, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aOU().a(this.gCr, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aOU().a(this.gCq, R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.gCo, (int) R.color.cp_cont_b);
            this.gCp.onChangeSkinType();
        }
    }

    public BdUniqueId eC(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext().getUniqueId();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext().getUniqueId();
        }
        return null;
    }
}
