package com.baidu.tieba.ala.person.playbacks;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.extrajump.ExtraJumpManager;
import com.baidu.live.tbadk.extrajump.interfaces.IExtraJump;
import com.baidu.live.view.AlaListEmptyView;
import com.baidu.tieba.ala.person.PersonCardActivity;
import com.baidu.tieba.ala.person.a.d;
import com.baidu.tieba.ala.person.adapter.a;
import com.baidu.tieba.ala.person.c.b;
import com.baidu.tieba.ala.person.view.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PersonPlayBacksListFragment extends BaseFragment {
    private Context context;
    private a hUV;
    private BdListView hUW;
    private e hUZ;
    private boolean hVa;
    private Object hVb;
    private AlaListEmptyView hVc;
    private b hXg;
    private boolean hXh = true;
    private String userId;

    public static PersonPlayBacksListFragment w(String str, Object obj) {
        PersonPlayBacksListFragment personPlayBacksListFragment = new PersonPlayBacksListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("user_id", str);
        personPlayBacksListFragment.setArguments(bundle);
        personPlayBacksListFragment.aw(obj);
        return personPlayBacksListFragment;
    }

    public void aw(Object obj) {
        this.hVb = obj;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext().getPageActivity();
        this.userId = getArguments().getString("user_id");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.ala_fragment_person_list, (ViewGroup) null);
        initData();
        am(inflate);
        initListener();
        cmv();
        return inflate;
    }

    private void Mk() {
        b(true, this.hVb);
    }

    private void initListener() {
        this.hUW.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.playbacks.PersonPlayBacksListFragment.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!PersonPlayBacksListFragment.this.hXh) {
                    PersonPlayBacksListFragment.this.hUZ.hide();
                } else {
                    PersonPlayBacksListFragment.this.loadData();
                }
            }
        });
        this.hUZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.playbacks.PersonPlayBacksListFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonPlayBacksListFragment.this.hUV != null && PersonPlayBacksListFragment.this.hUV.getCount() == 0) {
                    PersonPlayBacksListFragment.this.loadData();
                }
            }
        });
        this.hUV.a(new a.b() { // from class: com.baidu.tieba.ala.person.playbacks.PersonPlayBacksListFragment.3
            @Override // com.baidu.tieba.ala.person.adapter.a.b
            public void a(AlaLiveInfoData alaLiveInfoData, View view) {
                if (PersonPlayBacksListFragment.this.getPageContext().getOrignalPage() instanceof PersonCardActivity) {
                    PersonCardActivity personCardActivity = (PersonCardActivity) PersonPlayBacksListFragment.this.getPageContext().getOrignalPage();
                    if (!personCardActivity.Ii(TbadkCoreApplication.getCurrentAccount())) {
                        PersonPlayBacksListFragment.this.a(PersonPlayBacksListFragment.this.getPageContext(), alaLiveInfoData);
                    } else {
                        BdUtilHelper.showToast(personCardActivity.getActivity(), a.h.ala_person_owner_is_living);
                    }
                }
            }
        });
    }

    private void initData() {
        this.hXg = new b(getPageContext());
        this.hXg.a(new b.a() { // from class: com.baidu.tieba.ala.person.playbacks.PersonPlayBacksListFragment.4
            @Override // com.baidu.tieba.ala.person.c.b.a
            public void a(d dVar) {
                if (dVar != null) {
                    PersonPlayBacksListFragment.this.b(PersonPlayBacksListFragment.this.hVa, dVar);
                    if (PersonPlayBacksListFragment.this.hVa) {
                        PersonPlayBacksListFragment.this.hVa = false;
                        return;
                    }
                    return;
                }
                PersonPlayBacksListFragment.this.showToast(a.h.ala_person_load_fail);
                PersonPlayBacksListFragment.this.hUZ.wq(a.h.ala_person_load_fail_click);
            }

            @Override // com.baidu.tieba.ala.person.c.b.a
            public void onFail(String str) {
                PersonPlayBacksListFragment.this.showToast(str);
                PersonPlayBacksListFragment.this.hUV.a(true, null, 2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (obj != null && (obj instanceof d)) {
            this.hXh = ((d) obj).hVz.has_more == 1;
            if (((d) obj).hVz.has_more != 1) {
                this.hUZ.hide();
            } else {
                this.hUZ.rr(a.h.sdk_loading);
            }
            this.hUV.a(z, ((d) obj).cmy(), 2);
        }
    }

    private void cmv() {
        if (JavaTypesHelper.toLong(this.userId, 0L) == 0) {
            this.hUV.a(true, null, 2);
        } else if (this.hXg != null) {
            if (this.hVb == null) {
                this.hXg.setCurrentPage(-1);
                this.hVa = true;
                loadData();
                return;
            }
            this.hXg.setCurrentPage(0);
            Mk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.hXh) {
            this.hXg.setUid(this.userId);
            this.hXg.Ij(this.userId);
        }
    }

    private void am(View view) {
        this.hUW = (BdListView) view.findViewById(a.f.listview);
        this.hUV = new com.baidu.tieba.ala.person.adapter.a(this.context, 1);
        this.hUW.setAdapter((ListAdapter) this.hUV);
        this.hUZ = new e(getPageContext());
        this.hUZ.createView();
        this.hUW.setNextPage(this.hUZ);
        this.hUZ.display();
        this.hUZ.rr(a.h.sdk_loading);
        this.hVc = (AlaListEmptyView) view.findViewById(a.f.emptyview);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hVc.setParams(a.e.sdk_pic_live_empty01_hk, a.h.hk_ala_person_no_playbacks);
        } else {
            this.hVc.setParams(a.e.sdk_pic_live_empty04_qm, a.h.hk_ala_person_no_playbacks);
        }
        this.hUW.setEmptyView(this.hVc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, AlaLiveInfoData alaLiveInfoData) {
        if (tbPageContext != null && alaLiveInfoData != null) {
            long j = alaLiveInfoData.user_id;
            String nameShow = alaLiveInfoData.getNameShow();
            String str = alaLiveInfoData.feed_id;
            String str2 = alaLiveInfoData.media_url;
            String str3 = alaLiveInfoData.media_subtitle;
            String str4 = alaLiveInfoData.media_pic;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, j);
                jSONObject.put(TbEnum.SystemMessage.KEY_USER_NAME, nameShow);
                jSONObject.put("feedId", str);
                jSONObject.put("mediaUrl", str2);
                jSONObject.put("mediaTitle", str3);
                jSONObject.put("mediaPic", str4);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
            if (buildJumpExtra != null) {
                buildJumpExtra.jumpToPlayCallback(tbPageContext.getPageActivity(), jSONObject.toString());
                ((PersonCardActivity) getPageContext().getOrignalPage()).finish();
            }
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
