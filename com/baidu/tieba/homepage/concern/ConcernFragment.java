package com.baidu.tieba.homepage.concern;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import d.a.c.e.p.l;
import d.a.m0.r.q.w0;
import d.a.m0.z0.b0;
import d.a.n0.r0.o0;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class ConcernFragment extends BaseFragment implements o0 {

    /* renamed from: e  reason: collision with root package name */
    public ConcernPageView f16189e;

    /* renamed from: f  reason: collision with root package name */
    public ConcernPageView.l f16190f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16192h;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16191g = false;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f16193i = new a(2001115);
    public final AntiHelper.k j = new b();
    public CustomMessageListener k = new c(2921414);
    public final CustomMessageListener l = new d(2001383);
    public final d.a.c.c.g.a m = new e(CmdConfigHttp.CMD_GET_MY_POST, 303111);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f12638c == null || (message = updateAttentionMessage.getmOrginalMessage()) == null || message.getTag() == null || !message.getTag().equals(ConcernFragment.this.getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (AntiHelper.t(ConcernFragment.this.getActivity(), updateAttentionMessage.getData().l, ConcernFragment.this.j) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                } else if (updateAttentionMessage.getData().f12636a && updateAttentionMessage.getData().f12639d) {
                    l.L(ConcernFragment.this.getActivity(), R.string.attention_success);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AntiHelper.k {
        public b() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.m0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.m0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ConcernFragment.this.f16189e != null) {
                ConcernFragment.this.f16189e.G();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f16198e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f16199f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ long f16200g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ long f16201h;

            public a(PostWriteCallBackData postWriteCallBackData, long j, long j2, long j3) {
                this.f16198e = postWriteCallBackData;
                this.f16199f = j;
                this.f16200g = j2;
                this.f16201h = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                int k = l.k(TbadkCoreApplication.getInst());
                int i2 = l.i(TbadkCoreApplication.getInst());
                float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setProZone(this.f16198e.getProZone());
                requestGetMyPostNetMessage.setParams(this.f16199f, this.f16200g, this.f16201h, k, i2, f2, i3);
                requestGetMyPostNetMessage.setCallFrom(1);
                ConcernFragment.this.sendMessage(requestGetMyPostNetMessage);
            }
        }

        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PostWriteCallBackData postWriteCallBackData;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || (postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData()) == null) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(postWriteCallBackData.getPostId(), 0L);
            long f3 = d.a.c.e.m.b.f(postWriteCallBackData.getThreadId(), 0L);
            long f4 = d.a.c.e.m.b.f(d.a.n0.e3.q0.a.f().g(), 0L);
            if (f2 != 0 && f3 != 0 && f4 != 0) {
                d.a.c.e.m.e.a().postDelayed(new a(postWriteCallBackData, f3, f2, f4), 1000L);
            } else if (StringUtils.isNull(postWriteCallBackData.getVideoid())) {
            } else {
                WriteData writeData = postWriteCallBackData.writeDataForVideo;
                w0 w0Var = new w0();
                w0Var.L2(writeData);
                ConcernFragment.this.f16189e.y(w0Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends d.a.c.c.g.a {
        public e(int i2, int i3) {
            super(i2, i3);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
        @Override // d.a.c.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            String errorString;
            String errorString2;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof RequestGetMyPostNetMessage) {
                    z = ((RequestGetMyPostNetMessage) extra).showErrorToast();
                    if (!(responsedMessage instanceof GetMyPostHttpResponseMessage)) {
                        GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                        if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                            errorString2 = ConcernFragment.this.getResources().getString(R.string.neterror);
                        } else {
                            errorString2 = getMyPostHttpResponseMessage.getErrorString();
                        }
                        if (z || getMyPostHttpResponseMessage.getError() == 0) {
                            ConcernFragment.this.K0(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData());
                            return;
                        }
                        return;
                    } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                        GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                        if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                            errorString = ConcernFragment.this.getResources().getString(R.string.neterror);
                        } else {
                            errorString = getMyPostSocketResponseMessage.getErrorString();
                        }
                        if (z || getMyPostSocketResponseMessage.getError() == 0) {
                            ConcernFragment.this.K0(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData());
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
            z = true;
            if (!(responsedMessage instanceof GetMyPostHttpResponseMessage)) {
            }
        }
    }

    public ConcernFragment() {
    }

    @Override // d.a.n0.r0.o0
    public void H() {
    }

    @Override // d.a.n0.r0.o0
    public void I() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.f16189e.D(TbadkCoreApplication.getInst().getSkinType());
    }

    public void J0() {
        this.f16189e.r();
    }

    public final void K0(int i2, String str, GetMyPostResIdl getMyPostResIdl) {
        User_Info user_Info;
        if (i2 != 0) {
            showToast(str);
            return;
        }
        DataRes dataRes = getMyPostResIdl.data;
        if (dataRes == null || dataRes.thread_info == null) {
            return;
        }
        w0 w0Var = new w0();
        ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
        User.Builder builder2 = new User.Builder(builder.author);
        L0(builder2, getMyPostResIdl.data.user_info);
        User user = builder.author;
        if (user == null || TextUtils.isEmpty(user.name)) {
            builder.author = builder2.build(true);
        }
        User user2 = builder.author;
        if (user2 != null && (user_Info = getMyPostResIdl.data.user_info) != null && user2.name.equals(user_Info.name)) {
            builder.author = builder2.build(true);
        }
        builder.fname = d.a.n0.e3.q0.a.f().h();
        builder.fid = Long.valueOf(d.a.c.e.m.b.f(d.a.n0.e3.q0.a.f().h(), 0L));
        w0Var.V2(builder.build(true));
        this.f16189e.y(w0Var);
    }

    public final void L0(User.Builder builder, User_Info user_Info) {
        if (user_Info == null) {
            return;
        }
        Long l = user_Info.id;
        builder.id = l;
        builder.gender = user_Info.gender;
        builder.type = user_Info.type;
        builder.name = user_Info.name;
        builder.name_show = user_Info.name_show;
        if (l.longValue() == TbadkCoreApplication.getCurrentAccountId()) {
            builder.portrait = TbadkCoreApplication.getCurrentPortrait();
        } else {
            builder.portrait = user_Info.portrait;
        }
        builder.god_data = user_Info.god_data;
        builder.fans_num = user_Info.fans_num;
        builder.fans_nickname = user_Info.fans_nickname;
        builder.is_bawu = user_Info.is_bawu;
        builder.bawu_type = user_Info.bawu_type;
        builder.new_god_data = user_Info.new_god_data;
    }

    public void M0(ConcernPageView.l lVar) {
        this.f16190f = lVar;
        this.f16189e.setCallback(lVar);
    }

    public void N0(ScrollFragmentTabHost scrollFragmentTabHost) {
        ConcernPageView concernPageView = this.f16189e;
        if (concernPageView != null) {
            concernPageView.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void O0() {
        ConcernPageView concernPageView = this.f16189e;
        if (concernPageView != null) {
            concernPageView.J();
        }
    }

    public void P0(tbclient.Userlike.DataRes dataRes, boolean z) {
        ConcernPageView concernPageView = this.f16189e;
        if (concernPageView != null) {
            concernPageView.R(dataRes, z);
        }
    }

    public void Q0(String str, int i2) {
        this.f16189e.S(str, i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.m0.k0.a
    public String getCurrentPageKey() {
        return "a038";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.m0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(ListUtils.getItem(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.l.setTag(getBaseFragmentActivity().getUniqueId());
        this.l.setSelfListener(true);
        registerListener(this.l);
        this.m.getHttpMessageListener().setSelfListener(true);
        this.m.getSocketMessageListener().setSelfListener(true);
        registerListener(this.m);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.f16189e.D(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f16189e.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f16189e.getParent()).removeView(this.f16189e);
            ConcernPageView.l lVar = this.f16190f;
            if (lVar != null) {
                this.f16189e.setCallback(lVar);
            }
        }
        this.f16189e.setPageUniqueId(getUniqueId());
        if (this.f16191g) {
            this.f16189e.x();
            this.f16191g = false;
        }
        return this.f16189e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.l);
        this.f16189e.E();
        this.f16191g = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.f16193i);
        MessageManager.getInstance().unRegisterListener(this.k);
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f16189e.setTabInForeBackgroundState(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.f16192h) {
                ConcernPageView concernPageView = this.f16189e;
                if (concernPageView != null) {
                    concernPageView.s();
                }
                this.f16192h = true;
            }
            this.f16189e.setViewForeground();
            return;
        }
        this.f16189e.H();
        J0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ConcernPageView concernPageView = this.f16189e;
        if (concernPageView != null) {
            concernPageView.F();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // d.a.n0.r0.o0
    public void r() {
        if (this.f16192h) {
            this.f16189e.K();
        }
    }

    @Override // d.a.n0.r0.o0
    public void t() {
    }

    @Override // d.a.n0.r0.o0
    public void v() {
    }

    @Override // d.a.n0.r0.o0
    public void z(b0 b0Var) {
        ConcernPageView concernPageView = this.f16189e;
        if (concernPageView != null) {
            concernPageView.setRecommendFrsNavigationAnimDispatcher(b0Var);
        }
    }

    @SuppressLint({"ValidFragment"})
    public ConcernFragment(Context context) {
        ConcernPageView concernPageView = new ConcernPageView(context);
        this.f16189e = concernPageView;
        concernPageView.x();
        registerListener(this.f16193i);
        registerListener(this.k);
    }
}
