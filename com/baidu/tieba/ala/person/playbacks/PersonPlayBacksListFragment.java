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
    private a hVj;
    private BdListView hVk;
    private e hVn;
    private boolean hVo;
    private Object hVp;
    private AlaListEmptyView hVq;
    private b hXu;
    private boolean hXv = true;
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
        this.hVp = obj;
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
        cmC();
        return inflate;
    }

    private void Mk() {
        b(true, this.hVp);
    }

    private void initListener() {
        this.hVk.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.playbacks.PersonPlayBacksListFragment.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!PersonPlayBacksListFragment.this.hXv) {
                    PersonPlayBacksListFragment.this.hVn.hide();
                } else {
                    PersonPlayBacksListFragment.this.loadData();
                }
            }
        });
        this.hVn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.playbacks.PersonPlayBacksListFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonPlayBacksListFragment.this.hVj != null && PersonPlayBacksListFragment.this.hVj.getCount() == 0) {
                    PersonPlayBacksListFragment.this.loadData();
                }
            }
        });
        this.hVj.a(new a.b() { // from class: com.baidu.tieba.ala.person.playbacks.PersonPlayBacksListFragment.3
            @Override // com.baidu.tieba.ala.person.adapter.a.b
            public void a(AlaLiveInfoData alaLiveInfoData, View view) {
                if (PersonPlayBacksListFragment.this.getPageContext().getOrignalPage() instanceof PersonCardActivity) {
                    PersonCardActivity personCardActivity = (PersonCardActivity) PersonPlayBacksListFragment.this.getPageContext().getOrignalPage();
                    if (!personCardActivity.Ij(TbadkCoreApplication.getCurrentAccount())) {
                        PersonPlayBacksListFragment.this.a(PersonPlayBacksListFragment.this.getPageContext(), alaLiveInfoData);
                    } else {
                        BdUtilHelper.showToast(personCardActivity.getActivity(), a.h.ala_person_owner_is_living);
                    }
                }
            }
        });
    }

    private void initData() {
        this.hXu = new b(getPageContext());
        this.hXu.a(new b.a() { // from class: com.baidu.tieba.ala.person.playbacks.PersonPlayBacksListFragment.4
            @Override // com.baidu.tieba.ala.person.c.b.a
            public void a(d dVar) {
                if (dVar != null) {
                    PersonPlayBacksListFragment.this.b(PersonPlayBacksListFragment.this.hVo, dVar);
                    if (PersonPlayBacksListFragment.this.hVo) {
                        PersonPlayBacksListFragment.this.hVo = false;
                        return;
                    }
                    return;
                }
                PersonPlayBacksListFragment.this.showToast(a.h.ala_person_load_fail);
                PersonPlayBacksListFragment.this.hVn.wq(a.h.ala_person_load_fail_click);
            }

            @Override // com.baidu.tieba.ala.person.c.b.a
            public void onFail(String str) {
                PersonPlayBacksListFragment.this.showToast(str);
                PersonPlayBacksListFragment.this.hVj.a(true, null, 2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (obj != null && (obj instanceof d)) {
            this.hXv = ((d) obj).hVN.has_more == 1;
            if (((d) obj).hVN.has_more != 1) {
                this.hVn.hide();
            } else {
                this.hVn.rr(a.h.sdk_loading);
            }
            this.hVj.a(z, ((d) obj).cmF(), 2);
        }
    }

    private void cmC() {
        if (JavaTypesHelper.toLong(this.userId, 0L) == 0) {
            this.hVj.a(true, null, 2);
        } else if (this.hXu != null) {
            if (this.hVp == null) {
                this.hXu.setCurrentPage(-1);
                this.hVo = true;
                loadData();
                return;
            }
            this.hXu.setCurrentPage(0);
            Mk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.hXv) {
            this.hXu.setUid(this.userId);
            this.hXu.Ik(this.userId);
        }
    }

    private void am(View view) {
        this.hVk = (BdListView) view.findViewById(a.f.listview);
        this.hVj = new com.baidu.tieba.ala.person.adapter.a(this.context, 1);
        this.hVk.setAdapter((ListAdapter) this.hVj);
        this.hVn = new e(getPageContext());
        this.hVn.createView();
        this.hVk.setNextPage(this.hVn);
        this.hVn.display();
        this.hVn.rr(a.h.sdk_loading);
        this.hVq = (AlaListEmptyView) view.findViewById(a.f.emptyview);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hVq.setParams(a.e.sdk_pic_live_empty01_hk, a.h.hk_ala_person_no_playbacks);
        } else {
            this.hVq.setParams(a.e.sdk_pic_live_empty04_qm, a.h.hk_ala_person_no_playbacks);
        }
        this.hVk.setEmptyView(this.hVq);
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
