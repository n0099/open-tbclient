package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.AbilityTagItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.AddEmojiPendantVH;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.ElementFileItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.ElementItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.EmojiReplyPendantVH;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.SkillIconViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.SkillTagItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.TagItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.TagSugItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dr8 extends ks8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dr8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.ks8
    public BaseTagItemViewHolder b(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
            if (i == nr8.b) {
                return new TagItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0973, viewGroup, false), this.a);
            }
            if (i == lr8.d) {
                return new ElementItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0970, viewGroup, false), this.a);
            }
            if (i == kr8.c) {
                return new SkillTagItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d08d8, viewGroup, false), this.a);
            }
            if (i == jr8.a) {
                return new SkillIconViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d08d7, viewGroup, false), this.a);
            }
            if (i == mr8.f) {
                return new ElementFileItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0972, viewGroup, false), this.a);
            }
            if (i == gr8.d) {
                return new AbilityTagItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d096f, viewGroup, false), this.b, this.c);
            }
            if (i == or8.b) {
                return new TagSugItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0970, viewGroup, false), this.a);
            }
            if (i == ir8.d) {
                return new EmojiReplyPendantVH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0523, viewGroup, false), this.b);
            }
            if (i == hr8.b) {
                return new AddEmojiPendantVH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0523, viewGroup, false), this.b);
            }
            return null;
        }
        return (BaseTagItemViewHolder) invokeLI.objValue;
    }
}
