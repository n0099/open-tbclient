package com.baidu.tieba.hottopic.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import d.a.d.k.e.a;
import d.a.q0.g1.c.n;
/* loaded from: classes4.dex */
public class RelateCardForumAdapter extends a<n, CardGroupRelateForumHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HotTopicActivity m;
    public boolean n;
    public BdUniqueId o;

    /* loaded from: classes4.dex */
    public class CardGroupRelateForumHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f17118a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.q0.g1.f.a f17119b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CardGroupRelateForumHolder(RelateCardForumAdapter relateCardForumAdapter, d.a.q0.g1.f.a aVar) {
            super(aVar.k());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relateCardForumAdapter, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17118a = 3;
            this.f17119b = aVar;
        }

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f17118a == i2) {
                return;
            }
            d.a.q0.g1.f.a aVar = this.f17119b;
            if (aVar != null) {
                aVar.m(aVar.j(), i2);
            }
            this.f17118a = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelateCardForumAdapter(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hotTopicActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = true;
        this.o = null;
        this.m = hotTopicActivity;
        hotTopicActivity.getPageContext();
    }

    public BdUniqueId e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.o : (BdUniqueId) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: f0 */
    public CardGroupRelateForumHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            d.a.q0.g1.f.a aVar = new d.a.q0.g1.f.a(this.m.getPageContext());
            aVar.o(e0());
            aVar.setFrom(BaiduWalletServiceProviderMap.PLUGIN_WALLETHOME);
            this.n = true;
            return new CardGroupRelateForumHolder(this, aVar);
        }
        return (CardGroupRelateForumHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, n nVar, CardGroupRelateForumHolder cardGroupRelateForumHolder) {
        InterceptResult invokeCommon;
        d.a.q0.g1.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, nVar, cardGroupRelateForumHolder})) == null) {
            if (cardGroupRelateForumHolder == null || (aVar = cardGroupRelateForumHolder.f17119b) == null) {
                return null;
            }
            if (this.n) {
                aVar.l(nVar);
                this.n = false;
            }
            cardGroupRelateForumHolder.b(TbadkCoreApplication.getInst().getSkinType());
            return cardGroupRelateForumHolder.a();
        }
        return (View) invokeCommon.objValue;
    }
}
