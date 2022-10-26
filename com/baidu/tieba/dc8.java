package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.ReplyLinearLayout;
import com.baidu.tieba.xb8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class dc8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonPostModel.c a;
    public PersonPostModel b;
    public final String c;
    public BdUniqueId d;
    public String e;
    public TbPageContext f;
    public final PersonPostModel.c g;
    public final xb8.a h;

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes3.dex */
    public class a implements PersonPostModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dc8 a;

        public a(dc8 dc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dc8Var;
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
        public void i0(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, personPostModel, z) == null) {
                if (!z) {
                    if (this.a.b != null) {
                        for (int i = 0; i < personPostModel.postList.size(); i++) {
                            if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                                this.a.b.postList.add(personPostModel.postList.get(i));
                            }
                        }
                    }
                } else {
                    this.a.b = personPostModel;
                    Iterator it = this.a.b.postList.iterator();
                    while (it.hasNext()) {
                        eo eoVar = (eo) it.next();
                        if (eoVar != null && !(eoVar instanceof PersonPostModel.PostInfoList)) {
                            it.remove();
                        }
                    }
                }
                if (this.a.a != null) {
                    this.a.a.i0(personPostModel, z);
                }
                this.a.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements xb8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dc8 a;

        public b(dc8 dc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dc8Var;
        }

        @Override // com.baidu.tieba.xb8.a
        public void a(View view2) {
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f091a30) {
                    ((BaseFragmentActivity) this.a.f.getOrignalPage()).finish();
                } else if (id == R.id.obfuscated_res_0x7f0924cb) {
                    ((BaseFragmentActivity) this.a.f.getOrignalPage()).finish();
                } else if ((id == R.id.obfuscated_res_0x7f090f9e || id == R.id.obfuscated_res_0x7f091751 || id == R.id.obfuscated_res_0x7f090f94 || id == R.id.obfuscated_res_0x7f091be9) && (strArr = (String[]) view2.getTag()) != null) {
                    if (!"0".equals(strArr[2]) && strArr[1] != null) {
                        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(this.a.f.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                        createSubPbActivityConfig.setKeyPageStartFrom(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                        return;
                    }
                    PbActivityConfig createNormalCfg = new PbActivityConfig(this.a.f.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends xb8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ReplyLinearLayout r;
        public TextView s;
        public View t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View view2, TbPageContext tbPageContext) {
            super(view2, tbPageContext);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], (TbPageContext) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.t = view2.findViewById(R.id.obfuscated_res_0x7f09190a);
            this.i.setIsRound(true);
            ReplyLinearLayout replyLinearLayout = (ReplyLinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906f2);
            this.r = replyLinearLayout;
            replyLinearLayout.setPageContext(tbPageContext);
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091751);
            this.s = textView;
            textView.setOnClickListener(this);
            this.e.setVisibility(8);
        }

        @Override // com.baidu.tieba.xb8
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                super.a(i);
                nv4 d = nv4.d(this.s);
                d.v(R.color.CAM_X0107);
                d.n(R.string.J_X05);
                d.f(R.color.CAM_X0206);
                nv4 d2 = nv4.d(this.t);
                d2.n(R.string.J_X05);
                d2.f(R.color.CAM_X0201);
            }
        }
    }

    public dc8(TbPageContext tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, str2, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this);
        this.h = new b(this);
        this.f = tbPageContext;
        this.c = str;
        this.d = bdUniqueId;
    }

    public PersonPostModel.PostInfoList h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return (PersonPostModel.PostInfoList) this.b.postList.get(i);
        }
        return (PersonPostModel.PostInfoList) invokeI.objValue;
    }

    public void i(PersonPostModel.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.a = cVar;
        }
    }

    public void e() {
        PersonPostModel personPostModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (personPostModel = this.b) != null) {
            personPostModel.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PersonPostModel personPostModel = this.b;
            if (personPostModel != null && (arrayList = personPostModel.postList) != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (this.b == null) {
                PersonPostModel personPostModel = new PersonPostModel(this.f, this.d, null, true, PersonPostModel.FROM_PERSON_POST);
                this.b = personPostModel;
                personPostModel.setUniqueId(this.d);
            }
            this.b.fetchPost(this.f, this.g, z, this.c, false, true, false, null);
        }
    }

    public final void g(int i, c cVar, ViewGroup viewGroup) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, cVar, viewGroup) == null) {
            PersonPostModel.PostInfoList h = h(i);
            if (this.e == null) {
                this.e = h.user_portrait;
            }
            cVar.d(h, false, this.e);
            ArrayList arrayList = new ArrayList();
            int length = h.content.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (h.content[i2].post_content.length != 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (!h.content[i2].post_content[0].text.startsWith("回复 ")) {
                        stringBuffer.append("回复：");
                    }
                    int length2 = h.content[i2].post_content.length;
                    for (int i3 = 0; i3 < length2; i3++) {
                        stringBuffer.append(h.content[i2].post_content[i3].text);
                    }
                    if (h.content[i2].is_author_view == 1) {
                        str = " " + viewGroup.getContext().getString(R.string.obfuscated_res_0x7f0f0cd3);
                    } else {
                        str = "";
                    }
                    arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(h.thread_id), String.valueOf(h.content[i2].post_id), String.valueOf(h.content[i2].post_type), StringHelper.getFormatTime(h.content[i2].create_time * 1000) + str, String.valueOf(h.thread_type)});
                }
            }
            cVar.r.setPost(h);
            cVar.r.setContent(arrayList);
            if (Pattern.compile("^回复：").matcher(h.title).find()) {
                cVar.s.setText(h.title.replaceFirst("回复：", "原贴："));
            } else {
                cVar.s.setText(h.title);
            }
            OriginalThreadInfo originalThreadInfo = h.originalThreadInfo;
            if (originalThreadInfo != null && !StringUtils.isNull(originalThreadInfo.b)) {
                cVar.s.setText("分享：" + h.originalThreadInfo.b);
            }
            cVar.s.setTag(new String[]{String.valueOf(h.thread_id), null, null, String.valueOf(h.thread_type)});
            if (h.thread_type == 33) {
                cVar.s.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                cVar.s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            SkinManager.setBackgroundResource(cVar.s, R.drawable.person_post_line);
            SkinManager.setViewTextColor(cVar.s, R.color.common_color_10039, 1);
            int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
            cVar.s.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            cVar.c(this.h);
            cVar.a(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d072a, viewGroup, false);
                cVar = new c(view2, this.f);
                view2.setTag(cVar);
            } else {
                cVar = (c) view2.getTag();
            }
            if (i == 0) {
                cVar.h.setVisibility(0);
            } else {
                cVar.h.setVisibility(8);
            }
            g(i, cVar, viewGroup);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
