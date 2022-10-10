package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.vm8;
import com.baidu.tieba.write.view.xrichtext.RichImageItem;
import com.baidu.tieba.write.view.xrichtext.RichTextEditor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class i49 extends x39<f59> implements p49, q49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public RichTextEditor t;
    @Nullable
    public o49 u;
    @NonNull
    public final x59 v;
    public final RichImageItem.f w;

    /* loaded from: classes4.dex */
    public class a implements RichImageItem.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i49 a;

        public a(i49 i49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i49Var;
        }

        @Override // com.baidu.tieba.write.view.xrichtext.RichImageItem.f
        public void a(ImageFileInfo imageFileInfo, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, imageFileInfo, view2) == null) || this.a.b == null) {
                return;
            }
            if (ListUtils.isEmpty(this.a.v.f().getChosedFiles())) {
                this.a.b.h();
            }
            this.a.b.x(new int[]{10, 34});
        }

        @Override // com.baidu.tieba.write.view.xrichtext.RichImageItem.f
        public void b(ImageFileInfo imageFileInfo, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, view2) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i49(TbPageContext<?> tbPageContext, @NonNull x59 x59Var, @NonNull m39 m39Var, @NonNull t59 t59Var) {
        super(tbPageContext, f59.class, m39Var, t59Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, x59Var, m39Var, t59Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class) objArr2[1], (m39) objArr2[2], (t59) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = new a(this);
        this.v = x59Var;
        x59Var.c(this);
    }

    @Override // com.baidu.tieba.x39
    public void F(Editable editable) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            super.F(editable);
            WriteData writeData = this.e;
            if (writeData == null || (richTextEditor = this.t) == null) {
                return;
            }
            writeData.setRichContentData(richTextEditor.getPlainTextContentData());
        }
    }

    @Override // com.baidu.tieba.x39
    public void H(e15 e15Var) {
        RichTextEditor richTextEditor;
        ImageFileInfo b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e15Var) == null) || this.b == null || (richTextEditor = this.t) == null || richTextEditor.getVisibility() != 0 || (b = this.v.b(this.b, e15Var)) == null) {
            return;
        }
        U(b);
        this.b.h();
        this.b.x(new int[]{10, 34});
    }

    @Override // com.baidu.tieba.x39
    public void I(ArrayList<AtSelectData> arrayList) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) || (richTextEditor = this.t) == null) {
            return;
        }
        richTextEditor.h(arrayList);
    }

    @Override // com.baidu.tieba.x39
    public void J(ArrayList<AtSelectData> arrayList) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || (richTextEditor = this.t) == null) {
            return;
        }
        richTextEditor.l(arrayList);
    }

    @Override // com.baidu.tieba.x39
    @Nullable
    public ArrayList<AtSelectData> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor == null || richTextEditor.getVisibility() != 0) {
                return null;
            }
            return this.t.getAtDataInText();
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.x39
    @Nullable
    public EditText M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor == null || richTextEditor.getVisibility() != 0) {
                return null;
            }
            return this.t.getLastFocusEdit();
        }
        return (EditText) invokeV.objValue;
    }

    public void T(o49 o49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, o49Var) == null) {
            this.u = o49Var;
        }
    }

    public final void U(ImageFileInfo imageFileInfo) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, imageFileInfo) == null) || (richTextEditor = this.t) == null || this.e == null) {
            return;
        }
        richTextEditor.t(imageFileInfo);
        this.e.setRichContentData(this.t.getPlainTextContentData());
    }

    public void V(vm8.f fVar) {
        q59 q59Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) || (q59Var = this.l) == null) {
            return;
        }
        q59Var.p(fVar);
    }

    public final void W(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || str == null || this.b == null || this.t == null) {
            return;
        }
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
        writeImagesInfo.parseJson(str);
        writeImagesInfo.updateQuality();
        if (writeImagesInfo.getChosedFiles() == null || writeImagesInfo.getChosedFiles().size() <= 0) {
            return;
        }
        ImageFileInfo imageFileInfo = writeImagesInfo.getChosedFiles().get(0);
        int originalImgIndex = writeImagesInfo.getOriginalImgIndex();
        this.v.f().getChosedFiles().remove(originalImgIndex);
        this.v.f().getChosedFiles().add(originalImgIndex, imageFileInfo);
        this.t.p(imageFileInfo, writeImagesInfo.getOriginalImgViewIndex());
        this.b.x(new int[]{10, 34});
    }

    public final void X(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || str == null || this.b == null) {
            return;
        }
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
        writeImagesInfo.parseJson(str);
        writeImagesInfo.updateQuality();
        LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            for (ImageFileInfo imageFileInfo : chosedFiles) {
                this.v.f().addChooseFile(imageFileInfo);
                U(imageFileInfo);
            }
        }
        this.b.x(new int[]{10, 34});
        this.b.h();
    }

    @Override // com.baidu.tieba.t49
    public void a(boolean z) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || z || (richTextEditor = this.t) == null || richTextEditor.getLastFocusEdit() == null) {
            return;
        }
        this.t.getLastFocusEdit().clearFocus();
    }

    @Override // com.baidu.tieba.s49
    public void b(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, writeData) == null) {
            this.v.d(writeData);
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor == null || richTextEditor.getVisibility() != 0) {
                return;
            }
            this.t.setWriteImagesInfo(this.v.f());
            writeData.setRichContentData(this.t.getPostServerContentData());
            writeData.setServerRichContent(this.t.getPostServerContentData());
            writeData.setRichTextEditorMode(true);
        }
    }

    @Override // com.baidu.tieba.n49, com.baidu.tieba.s49
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.c();
            this.v.p(this);
        }
    }

    @Override // com.baidu.tieba.s49
    public void d(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, writeData) == null) {
            writeData.setRichTextEditorMode(true);
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null) {
                writeData.setRichContentData(richTextEditor.getPlainTextContentData());
            }
        }
    }

    @Override // com.baidu.tieba.t49
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.q49
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            s(str);
        }
    }

    @Override // com.baidu.tieba.x39, com.baidu.tieba.n49, com.baidu.tieba.s49
    public void h(@NonNull u49 u49Var) {
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, u49Var) == null) {
            super.h(u49Var);
            o49 o49Var = this.u;
            if (o49Var != null) {
                o49Var.l(this);
            }
            WriteImagesInfo f = this.v.f();
            if (f.size() <= 0 || (chosedFiles = f.getChosedFiles()) == null) {
                return;
            }
            for (ImageFileInfo imageFileInfo : chosedFiles) {
                if (imageFileInfo != null) {
                    U(imageFileInfo);
                }
            }
            u49 u49Var2 = this.b;
            if (u49Var2 != null) {
                u49Var2.h();
                this.b.x(new int[]{10, 34});
            }
        }
    }

    @Override // com.baidu.tieba.q49
    public void i(String str) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, str) == null) && (richTextEditor = this.t) != null && richTextEditor.getVisibility() == 0) {
            W(str);
        }
    }

    @Override // com.baidu.tieba.t49
    public void j() {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (richTextEditor = this.t) == null || richTextEditor.getLastFocusEdit() == null) {
            return;
        }
        this.t.getLastFocusEdit().requestFocus();
    }

    @Override // com.baidu.tieba.s49
    public void k(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, writeData) == null) || writeData.getWriteImagesInfo() == null) {
            return;
        }
        this.v.q(writeData.getWriteImagesInfo());
        RichTextEditor richTextEditor = this.t;
        if (richTextEditor != null) {
            richTextEditor.setWriteImagesInfo(writeData.getWriteImagesInfo());
            this.t.s(writeData.getRichContentData());
        }
        WriteData writeData2 = this.e;
        if (writeData2 != null) {
            writeData2.setWriteImagesInfo(writeData.getWriteImagesInfo());
            this.e.setRichContentData(writeData.getRichContentData());
        }
    }

    @Override // com.baidu.tieba.x39, com.baidu.tieba.n49, com.baidu.tieba.s49
    public void l(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, bundle, intent, writeData) == null) {
            super.l(bundle, intent, writeData);
            this.v.g(bundle, intent, writeData);
        }
    }

    @Override // com.baidu.tieba.t49
    public void m() {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (richTextEditor = this.t) == null) {
            return;
        }
        this.n.f(richTextEditor.getLastFocusEdit(), false);
    }

    @Override // com.baidu.tieba.t49
    public EditText o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null) {
                return richTextEditor.getLastFocusEdit();
            }
            return null;
        }
        return (EditText) invokeV.objValue;
    }

    @Override // com.baidu.tieba.x39, com.baidu.tieba.n49, com.baidu.tieba.s49
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048600, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            this.v.l(i, i2, intent);
        }
    }

    @Override // com.baidu.tieba.x39, com.baidu.tieba.s49
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            super.onChangeSkinType(i);
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null) {
                richTextEditor.w();
            }
        }
    }

    @Override // com.baidu.tieba.x39, com.baidu.tieba.n49, com.baidu.tieba.s49
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.v.n(bundle);
        }
    }

    @Override // com.baidu.tieba.p49
    public void onUpdate(Object obj) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, obj) == null) && (obj instanceof SelectForumData) && (richTextEditor = this.t) != null) {
            richTextEditor.setForumId(dh.g(((SelectForumData) obj).forumId, 0L));
        }
    }

    @Override // com.baidu.tieba.s49
    public View q(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04d0, viewGroup, false);
            this.c = inflate;
            this.g = inflate.findViewById(R.id.obfuscated_res_0x7f091a3e);
            this.h = (TbAlphaVideo) this.c.findViewById(R.id.obfuscated_res_0x7f09014e);
            RichTextEditor richTextEditor = (RichTextEditor) this.c.findViewById(R.id.obfuscated_res_0x7f091c20);
            this.t = richTextEditor;
            richTextEditor.setWriteImagesInfo(this.v.f());
            this.t.setOutImageOperateListener(this.w);
            this.t.setOnSpanGroupChangedListener(this.p);
            this.t.setEditOnClickListener(this.o);
            this.t.setEditOnFocusChangeListener(this.s);
            this.t.setBigEmotionSpanHandler(this.q);
            this.t.k(this.r);
            WriteData writeData = this.e;
            if (writeData != null) {
                this.t.setForumId(dh.g(writeData.getForumId(), 0L));
            }
            this.t.n();
            return this.c;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.n49, com.baidu.tieba.s49
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            RichTextEditor richTextEditor = this.t;
            return (richTextEditor == null || richTextEditor.u()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q49
    public void s(String str) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, str) == null) && (richTextEditor = this.t) != null && richTextEditor.getVisibility() == 0) {
            X(str);
        }
    }

    @Override // com.baidu.tieba.q49
    public void t(String str) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, str) == null) && (richTextEditor = this.t) != null && richTextEditor.getVisibility() == 0) {
            X(str);
        }
    }
}
