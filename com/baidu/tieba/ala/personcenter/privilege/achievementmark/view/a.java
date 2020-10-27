package com.baidu.tieba.ala.personcenter.privilege.achievementmark.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.data.AlaLiveMarkData;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.ala.view.AlaNetRefreshView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.c;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private View cZW;
    private TbPageContext<BaseFragmentActivity> eCn;
    private TextView gKQ;
    private HeadImageView ggE;
    private BdListView hAd;
    private b hAe;
    private TextView hAf;
    private TbImageView hAg;
    private RelativeLayout hAh;
    private ImageView hAi;
    private LinearLayout hAj;
    private AlaNetRefreshView hAk;
    private RelativeLayout hAl;
    private TextView hAm;
    private InterfaceC0686a hAn;
    private List<AlaLiveMarkData> hAo = new ArrayList();
    private b.a hAp = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.hAn != null) {
                a.this.hAn.a(bVar);
            }
        }
    };
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0686a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0686a interfaceC0686a) {
        this.eCn = tbPageContext;
        this.hAn = interfaceC0686a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.eCn.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.eCn.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.ggE = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.hAf = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.hAg = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.hAl = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.hAj = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.hAm = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.hAi = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.gKQ = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.cZW = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.hAd = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.hAe = new b(this.eCn, this.hAp);
        this.hAd.setAdapter((ListAdapter) this.hAe);
        this.hAh = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.hAd.setEmptyView(this.hAh);
        this.ggE.setIsRound(true);
        this.ggE.setDefaultBgResource(R.color.transparent);
        this.ggE.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hAg.setDefaultBgResource(R.color.transparent);
        this.hAg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mName, R.color.common_color_10310);
        ap.setViewTextColor(this.hAf, R.color.white_alpha70);
        ap.setViewTextColor(this.hAm, R.color.cp_cont_d);
        ap.setViewTextColor(this.gKQ, R.color.cp_cont_f);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.hAi.setAlpha(0.4f);
            this.cZW.setBackgroundColor(this.eCn.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.hAi.setAlpha(1.0f);
        this.cZW.setBackgroundColor(this.eCn.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.hAe != null && list != null) {
            this.hAe.setData(list);
        }
        a(alaUserInfoData);
    }

    private void a(AlaUserInfoData alaUserInfoData) {
        String format;
        if (alaUserInfoData != null) {
            String str = alaUserInfoData.user_nickname;
            String str2 = alaUserInfoData.user_name;
            if (str == null) {
                str = str2 != null ? str2 : TbadkApplication.getCurrentAccountNameShow();
            }
            String currentPortrait = alaUserInfoData.portrait == null ? TbadkApplication.getCurrentPortrait() : alaUserInfoData.portrait;
            if (alaUserInfoData.mark_count == null) {
                format = String.format(this.eCn.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.eCn.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            av(currentPortrait, str, format);
            int dimension = (int) this.eCn.getResources().getDimension(R.dimen.ds32);
            if (this.hAo != null && this.hAo.size() > 0) {
                this.hAo.clear();
            }
            if (this.hAj != null) {
                this.hAj.removeAllViews();
                this.hAo = alaUserInfoData.live_mark_info_new;
                if (this.hAo != null) {
                    for (int i = 0; i < this.hAo.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.eCn.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.hAo.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.eCn.getResources().getDimension(R.dimen.ds12);
                        this.hAj.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        av(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.eCn.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.hAo != null && this.hAo.size() > 0) {
            this.hAo.clear();
        }
        if (this.hAj != null) {
            this.hAj.removeAllViews();
        }
    }

    private void av(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.ggE.startLoad(str, 25, false);
            com.baidu.adp.lib.e.c.mS().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.hAg.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.hAg.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.ggE.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
            this.hAg.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.hAf.setText(str3);
        } else {
            this.hAf.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.eCn != null) {
            if (this.hAk == null) {
                this.hAk = new AlaNetRefreshView(this.eCn.getPageActivity());
            }
            this.hAk.setImageResource(i);
            this.hAk.setNetFailTipText(this.eCn.getString(i2));
            this.hAk.onChangeSkinType();
            this.hAk.setIsShowRefreshButton(z);
            if (z) {
                this.hAk.setOnRefreshClickListener(onClickListener);
            }
            this.hAk.attachView(this.hAl);
        }
    }

    public void TK() {
        if (this.hAk != null) {
            this.hAk.dettachView(this.hAl);
        }
    }
}
