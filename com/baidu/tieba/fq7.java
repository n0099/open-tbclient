package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ChatRoomInfoData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class fq7 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public static BdUniqueId d;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public b b;
    public List<ChatRoomInfoData> c;

    /* loaded from: classes4.dex */
    public interface b {
        void a(View view2, ChatRoomInfoData chatRoomInfoData);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;
        public TextView b;
        public TbRichTextView c;
        public ChatRoomInfoData d;
        public TextView e;
        public final CustomMessageListener f;

        /* loaded from: classes4.dex */
        public class a extends CustomMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, int i) {
                super(i);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                    this.a.c(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        }

        public c(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = new a(this, 2001304);
            HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f09062e);
            this.a = headImageView;
            headImageView.setIsRound(true);
            this.a.setPlaceHolder(1);
            this.a.setBorderWidth(UtilHelper.getDimenPixelSize(R.dimen.L_X04));
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090636);
            this.c = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f090624);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09061d);
            this.c.setMaxLines(1);
            this.c.setTextEllipsize(TextUtils.TruncateAt.END);
            this.c.setAddTruncateListener(true);
            this.c.setClickable(false);
        }

        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.setSkinType(i);
                this.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0211));
                p15 d = p15.d(this.b);
                d.A(R.string.F_X02);
                d.z(R.dimen.T_X06);
                d.v(R.color.CAM_X0105);
                p15.d(this.c).A(R.string.F_X01);
                this.c.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X08));
                this.c.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
                this.c.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0109));
                p15 d2 = p15.d(this.e);
                d2.v(R.color.CAM_X0301);
                d2.A(R.string.F_X01);
                d2.z(R.dimen.T_X08);
            }
        }

        public ChatRoomInfoData b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.d;
            }
            return (ChatRoomInfoData) invokeV.objValue;
        }

        public void d(TbPageContext<?> tbPageContext, @NonNull ChatRoomInfoData chatRoomInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, chatRoomInfoData) == null) {
                ChatRoomInfoData.ChatroomInfoBasicData chatroomInfoBasicData = chatRoomInfoData.getChatroomInfoBasicData();
                ChatRoomInfoData.ChatroomMEMsgInfoData chatroomMEMsgInfoData = chatRoomInfoData.getChatroomMEMsgInfoData();
                if (chatroomInfoBasicData != null && chatroomMEMsgInfoData != null) {
                    this.d = chatRoomInfoData;
                    this.a.K(chatroomInfoBasicData.getAvatar(), 10, false);
                    this.b.setText(chatroomInfoBasicData.getName());
                    if (StringUtils.isNull(chatroomMEMsgInfoData.getContent())) {
                        this.c.setVisibility(8);
                    } else {
                        this.c.setVisibility(0);
                        String str = "";
                        if (!TextUtils.isEmpty(chatroomMEMsgInfoData.getFromName())) {
                            str = "" + chatroomMEMsgInfoData.getFromName() + tbPageContext.getString(R.string.obfuscated_res_0x7f0f03c7);
                        }
                        if (!TextUtils.isEmpty(chatroomMEMsgInfoData.getContent())) {
                            str = str + chatroomMEMsgInfoData.getContent();
                        }
                        this.c.setText(new TbRichText(hj7.c(str, 1)));
                    }
                    if (chatRoomInfoData.getAtInfoData() != null && chatRoomInfoData.getAtInfoData().getAtCountAll() > 0) {
                        this.e.setVisibility(0);
                        this.e.setText(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0868));
                        return;
                    }
                    this.e.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ fq7 b;

        public a(fq7 fq7Var, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fq7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fq7Var;
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.b != null) {
                this.b.b.a(view2, this.a.b());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947772861, "Lcom/baidu/tieba/fq7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947772861, "Lcom/baidu/tieba/fq7;");
                return;
            }
        }
        d = BdUniqueId.gen();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!ListUtils.isEmpty(this.c)) {
                return this.c.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public fq7(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.a = tbPageContext;
    }

    public final void b(List<ChatRoomInfoData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (int i = 0; i < 10; i++) {
                this.c.add(new ChatRoomInfoData());
            }
            this.c.set(0, list.get(0));
            notifyDataSetChanged();
        }
    }

    public void c(List<ChatRoomInfoData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (ListUtils.isEmpty(this.c)) {
            b(list);
        } else {
            this.c.set(0, list.get(0));
        }
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.b = bVar;
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            List<ChatRoomInfoData> list = this.c;
            if (list == null) {
                return null;
            }
            return list.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01c4, viewGroup, false);
                cVar = new c(view2);
                view2.setTag(cVar);
            } else {
                cVar = (c) view2.getTag();
                MessageManager.getInstance().unRegisterListener(cVar.f);
            }
            if (!ListUtils.isEmpty(this.c)) {
                cVar.d(this.a, this.c.get(0));
            }
            cVar.f.setTag(d);
            MessageManager.getInstance().registerListener(cVar.f);
            cVar.c(TbadkCoreApplication.getInst().getSkinType());
            view2.setOnClickListener(new a(this, cVar));
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
