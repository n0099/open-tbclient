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
    private View cRA;
    private TbPageContext<BaseFragmentActivity> etO;
    private HeadImageView fWA;
    private TextView gzc;
    private BdListView hoi;
    private b hoj;
    private TextView hok;
    private TbImageView hol;
    private RelativeLayout hom;
    private ImageView hon;
    private LinearLayout hoo;
    private AlaNetRefreshView hop;
    private RelativeLayout hoq;
    private TextView hor;
    private InterfaceC0670a hos;
    private List<AlaLiveMarkData> hot = new ArrayList();
    private b.a hou = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.hos != null) {
                a.this.hos.a(bVar);
            }
        }
    };
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0670a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0670a interfaceC0670a) {
        this.etO = tbPageContext;
        this.hos = interfaceC0670a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.etO.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.etO.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.fWA = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.hok = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.hol = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.hoq = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.hoo = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.hor = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.hon = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.gzc = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.cRA = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.hoi = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.hoj = new b(this.etO, this.hou);
        this.hoi.setAdapter((ListAdapter) this.hoj);
        this.hom = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.hoi.setEmptyView(this.hom);
        this.fWA.setIsRound(true);
        this.fWA.setDefaultBgResource(R.color.transparent);
        this.fWA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hol.setDefaultBgResource(R.color.transparent);
        this.hol.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mName, R.color.common_color_10310);
        ap.setViewTextColor(this.hok, R.color.white_alpha70);
        ap.setViewTextColor(this.hor, R.color.cp_cont_d);
        ap.setViewTextColor(this.gzc, R.color.cp_cont_f);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.hon.setAlpha(0.4f);
            this.cRA.setBackgroundColor(this.etO.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.hon.setAlpha(1.0f);
        this.cRA.setBackgroundColor(this.etO.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.hoj != null && list != null) {
            this.hoj.setData(list);
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
                format = String.format(this.etO.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.etO.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            ao(currentPortrait, str, format);
            int dimension = (int) this.etO.getResources().getDimension(R.dimen.ds32);
            if (this.hot != null && this.hot.size() > 0) {
                this.hot.clear();
            }
            if (this.hoo != null) {
                this.hoo.removeAllViews();
                this.hot = alaUserInfoData.live_mark_info_new;
                if (this.hot != null) {
                    for (int i = 0; i < this.hot.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.etO.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.hot.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.etO.getResources().getDimension(R.dimen.ds12);
                        this.hoo.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        ao(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.etO.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.hot != null && this.hot.size() > 0) {
            this.hot.clear();
        }
        if (this.hoo != null) {
            this.hoo.removeAllViews();
        }
    }

    private void ao(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.fWA.startLoad(str, 25, false);
            com.baidu.adp.lib.e.c.mS().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.hol.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.hol.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.fWA.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
            this.hol.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.hok.setText(str3);
        } else {
            this.hok.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.etO != null) {
            if (this.hop == null) {
                this.hop = new AlaNetRefreshView(this.etO.getPageActivity());
            }
            this.hop.setImageResource(i);
            this.hop.setNetFailTipText(this.etO.getString(i2));
            this.hop.onChangeSkinType();
            this.hop.setIsShowRefreshButton(z);
            if (z) {
                this.hop.setOnRefreshClickListener(onClickListener);
            }
            this.hop.attachView(this.hoq);
        }
    }

    public void SK() {
        if (this.hop != null) {
            this.hop.dettachView(this.hoq);
        }
    }
}
