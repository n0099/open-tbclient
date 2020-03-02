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
    private TbPageContext<BaseFragmentActivity> cVh;
    private View czt;
    private TextView eLK;
    private HeadImageView eoh;
    private BdListView fwe;
    private b fwf;
    private TextView fwg;
    private TbImageView fwh;
    private RelativeLayout fwi;
    private ImageView fwj;
    private LinearLayout fwk;
    private AlaNetRefreshView fwl;
    private RelativeLayout fwm;
    private TextView fwn;
    private InterfaceC0480a fwo;
    private List<AlaLiveMarkData> fwp = new ArrayList();
    private b.a fwq = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.fwo != null) {
                a.this.fwo.a(bVar);
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
        this.cVh = tbPageContext;
        this.fwo = interfaceC0480a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.cVh.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.cVh.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.eoh = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.fwg = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.fwh = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.fwm = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.fwk = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.fwn = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.fwj = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.eLK = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.czt = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.fwe = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.fwf = new b(this.cVh, this.fwq);
        this.fwe.setAdapter((ListAdapter) this.fwf);
        this.fwi = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.fwe.setEmptyView(this.fwi);
        this.eoh.setIsRound(true);
        this.eoh.setDefaultBgResource(R.color.transparent);
        this.eoh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fwh.setDefaultBgResource(R.color.transparent);
        this.fwh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mName, (int) R.color.common_color_10310);
        am.setViewTextColor(this.fwg, (int) R.color.white_alpha70);
        am.setViewTextColor(this.fwn, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eLK, (int) R.color.cp_cont_f);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.fwj.setAlpha(0.4f);
            this.czt.setBackgroundColor(this.cVh.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.fwj.setAlpha(1.0f);
        this.czt.setBackgroundColor(this.cVh.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.fwf != null && list != null) {
            this.fwf.setData(list);
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
                format = String.format(this.cVh.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.cVh.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            ah(currentPortrait, str, format);
            int dimension = (int) this.cVh.getResources().getDimension(R.dimen.ds32);
            if (this.fwp != null && this.fwp.size() > 0) {
                this.fwp.clear();
            }
            if (this.fwk != null) {
                this.fwk.removeAllViews();
                this.fwp = alaUserInfoData.live_mark_info_new;
                if (this.fwp != null) {
                    for (int i = 0; i < this.fwp.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.cVh.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.fwp.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.cVh.getResources().getDimension(R.dimen.ds12);
                        this.fwk.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        ah(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.cVh.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.fwp != null && this.fwp.size() > 0) {
            this.fwp.clear();
        }
        if (this.fwk != null) {
            this.fwk.removeAllViews();
        }
    }

    private void ah(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.eoh.startLoad(str, 25, false);
            com.baidu.adp.lib.e.c.gr().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.fwh.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.fwh.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.eoh.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            this.fwh.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.fwg.setText(str3);
        } else {
            this.fwg.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.cVh != null) {
            if (this.fwl == null) {
                this.fwl = new AlaNetRefreshView(this.cVh.getPageActivity());
            }
            this.fwl.setImageResource(i);
            this.fwl.setNetFailTipText(this.cVh.getString(i2));
            this.fwl.onChangeSkinType();
            this.fwl.setIsShowRefreshButton(z);
            if (z) {
                this.fwl.setOnRefreshClickListener(onClickListener);
            }
            this.fwl.attachView(this.fwm);
        }
    }

    public void bcx() {
        if (this.fwl != null) {
            this.fwl.dettachView(this.fwm);
        }
    }
}
