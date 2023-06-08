package com.baidu.tieba;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class fe9 extends in6<pd9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public LinearLayout q;
    public LinearLayout r;
    public LinearLayout s;
    public LinearLayout t;
    public UserData u;
    public int v;
    public int w;

    @Override // com.baidu.tieba.in6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d078d : invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements CacheModel.c<ny8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fe9 a;

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void l(WriteCacheRespMsg<List<ny8>> writeCacheRespMsg, WriteCacheMessage<ny8> writeCacheMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, writeCacheRespMsg, writeCacheMessage) == null) {
            }
        }

        public a(fe9 fe9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fe9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fe9Var;
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void q(ReadCacheRespMsg<List<ny8>> readCacheRespMsg, ReadCacheMessage<ny8> readCacheMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, readCacheRespMsg, readCacheMessage) == null) && readCacheRespMsg != null && readCacheRespMsg.getData() != null) {
                this.a.m.setText(Integer.toString(readCacheRespMsg.getData().size()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fe9(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = 3;
        this.w = 0;
        View h = h();
        this.i = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0902e8);
        this.j = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0902e9);
        this.k = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09243d);
        this.l = (TextView) h.findViewById(R.id.thread_title);
        this.m = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090f22);
        this.n = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090f23);
        this.o = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090736);
        this.p = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090737);
        this.q = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f0902e7);
        this.r = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f092410);
        this.t = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f090f21);
        this.s = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f090735);
    }

    @Override // com.baidu.tieba.in6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) && this.v != i) {
            o75 d = o75.d(h());
            d.o(R.string.J_X14);
            d.n(1);
            d.f(R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0109);
            this.v = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, view2) != null) || view2 == null) {
            return;
        }
        if (view2.getId() == R.id.obfuscated_res_0x7f090ac6) {
            if (this.u == null) {
                return;
            }
            PersonRedTipManager.getInstance().updateRedTipState(2, false, true);
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 6));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.b.getPageActivity(), false, this.u.getUserId(), this.u.getSex()).updateBjhUser(this.u.isBaijiahaoUser())));
        } else if (view2.getId() == R.id.obfuscated_res_0x7f090784) {
            if (this.u == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 5));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.b.getPageActivity(), true, this.u.getUserId(), this.u.getSex()).updateBjhUser(this.u.isBaijiahaoUser()).updateFollowNum(this.w, this.u.getPortrait())));
        } else if (view2.getId() == R.id.obfuscated_res_0x7f0902e7) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 7));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.b.getPageActivity(), this.u.getLike_bars(), this.u.getUserId(), this.u.getSex())));
        } else if (view2.getId() == R.id.obfuscated_res_0x7f092410) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 8));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.b.getPageActivity(), this.u.getUserId(), this.u.getSex(), this.u.getPortrait())));
        } else if (view2.getId() == R.id.obfuscated_res_0x7f090735) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 9));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(getContext())));
        } else if (view2.getId() == R.id.obfuscated_res_0x7f090f21) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 10));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(getContext())));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in6
    /* renamed from: s */
    public void i(pd9 pd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pd9Var) == null) {
            this.u = pd9Var.e;
            this.w = pd9Var.a;
            this.i.setText(Integer.toString(pd9Var.b));
            this.k.setText(StringHelper.longNumFormatOver9999wan(pd9Var.c));
            PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(this.b);
            pbHistoryCacheModel.m0(new a(this));
            pbHistoryCacheModel.j0();
            this.o.setText(Integer.toString(this.u.getFavoriteNum()));
            this.q.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.s.setOnClickListener(this);
            j(g(), TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
