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
    private View cFw;
    private TbPageContext<BaseFragmentActivity> ehG;
    private HeadImageView fKj;
    private BdListView gZh;
    private b gZi;
    private TextView gZj;
    private TbImageView gZk;
    private RelativeLayout gZl;
    private ImageView gZm;
    private LinearLayout gZn;
    private AlaNetRefreshView gZo;
    private RelativeLayout gZp;
    private TextView gZq;
    private InterfaceC0652a gZr;
    private List<AlaLiveMarkData> gZs = new ArrayList();
    private b.a gZt = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.gZr != null) {
                a.this.gZr.a(bVar);
            }
        }
    };
    private TextView gkJ;
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0652a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0652a interfaceC0652a) {
        this.ehG = tbPageContext;
        this.gZr = interfaceC0652a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.ehG.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.ehG.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.fKj = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.gZj = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.gZk = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.gZp = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.gZn = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.gZq = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.gZm = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.gkJ = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.cFw = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.gZh = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.gZi = new b(this.ehG, this.gZt);
        this.gZh.setAdapter((ListAdapter) this.gZi);
        this.gZl = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.gZh.setEmptyView(this.gZl);
        this.fKj.setIsRound(true);
        this.fKj.setDefaultBgResource(R.color.transparent);
        this.fKj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gZk.setDefaultBgResource(R.color.transparent);
        this.gZk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mName, R.color.common_color_10310);
        ap.setViewTextColor(this.gZj, R.color.white_alpha70);
        ap.setViewTextColor(this.gZq, R.color.cp_cont_d);
        ap.setViewTextColor(this.gkJ, R.color.cp_cont_f);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.gZm.setAlpha(0.4f);
            this.cFw.setBackgroundColor(this.ehG.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.gZm.setAlpha(1.0f);
        this.cFw.setBackgroundColor(this.ehG.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.gZi != null && list != null) {
            this.gZi.setData(list);
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
                format = String.format(this.ehG.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.ehG.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            am(currentPortrait, str, format);
            int dimension = (int) this.ehG.getResources().getDimension(R.dimen.ds32);
            if (this.gZs != null && this.gZs.size() > 0) {
                this.gZs.clear();
            }
            if (this.gZn != null) {
                this.gZn.removeAllViews();
                this.gZs = alaUserInfoData.live_mark_info_new;
                if (this.gZs != null) {
                    for (int i = 0; i < this.gZs.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.ehG.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.gZs.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.ehG.getResources().getDimension(R.dimen.ds12);
                        this.gZn.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        am(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.ehG.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.gZs != null && this.gZs.size() > 0) {
            this.gZs.clear();
        }
        if (this.gZn != null) {
            this.gZn.removeAllViews();
        }
    }

    private void am(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.fKj.startLoad(str, 25, false);
            com.baidu.adp.lib.e.c.mR().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.gZk.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.gZk.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.fKj.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
            this.gZk.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.gZj.setText(str3);
        } else {
            this.gZj.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.ehG != null) {
            if (this.gZo == null) {
                this.gZo = new AlaNetRefreshView(this.ehG.getPageActivity());
            }
            this.gZo.setImageResource(i);
            this.gZo.setNetFailTipText(this.ehG.getString(i2));
            this.gZo.onChangeSkinType();
            this.gZo.setIsShowRefreshButton(z);
            if (z) {
                this.gZo.setOnRefreshClickListener(onClickListener);
            }
            this.gZo.attachView(this.gZp);
        }
    }

    public void bHn() {
        if (this.gZo != null) {
            this.gZo.dettachView(this.gZp);
        }
    }
}
