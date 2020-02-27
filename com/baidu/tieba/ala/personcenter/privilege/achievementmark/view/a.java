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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.c;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private TbPageContext<BaseFragmentActivity> cVg;
    private View czs;
    private TextView eLJ;
    private HeadImageView eog;
    private BdListView fwd;
    private b fwe;
    private TextView fwf;
    private TbImageView fwg;
    private RelativeLayout fwh;
    private ImageView fwi;
    private LinearLayout fwj;
    private AlaNetRefreshView fwk;
    private RelativeLayout fwl;
    private TextView fwm;
    private InterfaceC0480a fwn;
    private List<AlaLiveMarkData> fwo = new ArrayList();
    private b.a fwp = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.fwn != null) {
                a.this.fwn.a(bVar);
            }
        }
    };
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0480a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0480a interfaceC0480a) {
        this.cVg = tbPageContext;
        this.fwn = interfaceC0480a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.cVg.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.cVg.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.eog = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.fwf = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.fwg = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.fwl = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.fwj = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.fwm = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.fwi = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.eLJ = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.czs = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.fwd = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.fwe = new b(this.cVg, this.fwp);
        this.fwd.setAdapter((ListAdapter) this.fwe);
        this.fwh = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.fwd.setEmptyView(this.fwh);
        this.eog.setIsRound(true);
        this.eog.setDefaultBgResource(R.color.transparent);
        this.eog.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fwg.setDefaultBgResource(R.color.transparent);
        this.fwg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mName, (int) R.color.common_color_10310);
        am.setViewTextColor(this.fwf, (int) R.color.white_alpha70);
        am.setViewTextColor(this.fwm, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eLJ, (int) R.color.cp_cont_f);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.fwi.setAlpha(0.4f);
            this.czs.setBackgroundColor(this.cVg.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.fwi.setAlpha(1.0f);
        this.czs.setBackgroundColor(this.cVg.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.fwe != null && list != null) {
            this.fwe.setData(list);
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
                format = String.format(this.cVg.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.cVg.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            ah(currentPortrait, str, format);
            int dimension = (int) this.cVg.getResources().getDimension(R.dimen.ds32);
            if (this.fwo != null && this.fwo.size() > 0) {
                this.fwo.clear();
            }
            if (this.fwj != null) {
                this.fwj.removeAllViews();
                this.fwo = alaUserInfoData.live_mark_info_new;
                if (this.fwo != null) {
                    for (int i = 0; i < this.fwo.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.cVg.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.fwo.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.cVg.getResources().getDimension(R.dimen.ds12);
                        this.fwj.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        ah(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.cVg.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.fwo != null && this.fwo.size() > 0) {
            this.fwo.clear();
        }
        if (this.fwj != null) {
            this.fwj.removeAllViews();
        }
    }

    private void ah(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.eog.startLoad(str, 25, false);
            com.baidu.adp.lib.e.c.gr().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.fwg.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.fwg.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.eog.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            this.fwg.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.fwf.setText(str3);
        } else {
            this.fwf.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.cVg != null) {
            if (this.fwk == null) {
                this.fwk = new AlaNetRefreshView(this.cVg.getPageActivity());
            }
            this.fwk.setImageResource(i);
            this.fwk.setNetFailTipText(this.cVg.getString(i2));
            this.fwk.onChangeSkinType();
            this.fwk.setIsShowRefreshButton(z);
            if (z) {
                this.fwk.setOnRefreshClickListener(onClickListener);
            }
            this.fwk.attachView(this.fwl);
        }
    }

    public void bcv() {
        if (this.fwk != null) {
            this.fwk.dettachView(this.fwl);
        }
    }
}
