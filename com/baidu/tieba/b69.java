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
import com.baidu.tieba.lo8;
import com.baidu.tieba.write.view.xrichtext.RichImageItem;
import com.baidu.tieba.write.view.xrichtext.RichTextEditor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class b69 extends p59<b79> implements j69, k69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public RichTextEditor t;
    @Nullable
    public i69 u;
    @NonNull
    public final x79 v;
    public final RichImageItem.f w;

    @Override // com.baidu.tieba.n69
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes3.dex */
    public class a implements RichImageItem.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b69 a;

        @Override // com.baidu.tieba.write.view.xrichtext.RichImageItem.f
        public void b(ImageFileInfo imageFileInfo, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, view2) == null) {
            }
        }

        public a(b69 b69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b69Var;
        }

        @Override // com.baidu.tieba.write.view.xrichtext.RichImageItem.f
        public void a(ImageFileInfo imageFileInfo, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, imageFileInfo, view2) != null) || this.a.b == null) {
                return;
            }
            if (ListUtils.isEmpty(this.a.v.g().getChosedFiles())) {
                this.a.b.i();
            }
            this.a.b.x(new int[]{10, 34});
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b69(TbPageContext<?> tbPageContext, @NonNull x79 x79Var, @NonNull b59 b59Var, @NonNull t79 t79Var) {
        super(tbPageContext, b79.class, b59Var, t79Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, x79Var, b59Var, t79Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class) objArr2[1], (b59) objArr2[2], (t79) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = new a(this);
        this.v = x79Var;
        x79Var.c(this);
    }

    @Override // com.baidu.tieba.p59
    public void H(Editable editable) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            super.H(editable);
            WriteData writeData = this.e;
            if (writeData != null && (richTextEditor = this.t) != null) {
                writeData.setRichContentData(richTextEditor.getPlainTextContentData());
            }
        }
    }

    @Override // com.baidu.tieba.p59
    public void K(ArrayList<AtSelectData> arrayList) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) != null) || (richTextEditor = this.t) == null) {
            return;
        }
        richTextEditor.h(arrayList);
    }

    @Override // com.baidu.tieba.p59
    public void L(ArrayList<AtSelectData> arrayList) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, arrayList) != null) || (richTextEditor = this.t) == null) {
            return;
        }
        richTextEditor.l(arrayList);
    }

    public void V(i69 i69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, i69Var) == null) {
            this.u = i69Var;
        }
    }

    public final void W(ImageFileInfo imageFileInfo) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, imageFileInfo) == null) && (richTextEditor = this.t) != null && this.e != null) {
            richTextEditor.t(imageFileInfo);
            this.e.setRichContentData(this.t.getPlainTextContentData());
        }
    }

    public void X(lo8.f fVar) {
        q79 q79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) && (q79Var = this.l) != null) {
            q79Var.p(fVar);
        }
    }

    @Override // com.baidu.tieba.n69
    public void b(boolean z) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && !z && (richTextEditor = this.t) != null && richTextEditor.getLastFocusEdit() != null) {
            this.t.getLastFocusEdit().clearFocus();
        }
    }

    @Override // com.baidu.tieba.m69
    public void e(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, writeData) == null) {
            writeData.setRichTextEditorMode(true);
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null) {
                writeData.setRichContentData(richTextEditor.getPlainTextContentData());
            }
        }
    }

    @Override // com.baidu.tieba.k69
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            u(str);
        }
    }

    @Override // com.baidu.tieba.k69
    public void k(String str) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, str) == null) && (richTextEditor = this.t) != null && richTextEditor.getVisibility() == 0) {
            Y(str);
        }
    }

    @Override // com.baidu.tieba.p59, com.baidu.tieba.m69
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            super.onChangeSkinType(i);
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null) {
                richTextEditor.w();
            }
        }
    }

    @Override // com.baidu.tieba.p59, com.baidu.tieba.h69, com.baidu.tieba.m69
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.v.o(bundle);
        }
    }

    @Override // com.baidu.tieba.j69
    public void onUpdate(Object obj) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, obj) == null) && (obj instanceof SelectForumData) && (richTextEditor = this.t) != null) {
            richTextEditor.setForumId(wg.g(((SelectForumData) obj).forumId, 0L));
        }
    }

    @Override // com.baidu.tieba.k69
    public void u(String str) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, str) == null) && (richTextEditor = this.t) != null && richTextEditor.getVisibility() == 0) {
            Z(str);
        }
    }

    @Override // com.baidu.tieba.k69
    public void v(String str) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, str) == null) && (richTextEditor = this.t) != null && richTextEditor.getVisibility() == 0) {
            Z(str);
        }
    }

    @Override // com.baidu.tieba.p59
    public void J(z15 z15Var) {
        RichTextEditor richTextEditor;
        ImageFileInfo b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z15Var) == null) && this.b != null && (richTextEditor = this.t) != null && richTextEditor.getVisibility() == 0 && (b = this.v.b(this.b, z15Var)) != null) {
            W(b);
            this.b.i();
            this.b.x(new int[]{10, 34});
        }
    }

    @Override // com.baidu.tieba.m69
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, writeData) == null) {
            this.v.d(writeData);
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null && richTextEditor.getVisibility() == 0) {
                this.t.setWriteImagesInfo(this.v.g());
                writeData.setRichContentData(this.t.getPostServerContentData());
                writeData.setServerRichContent(this.t.getPostServerContentData());
                writeData.setRichTextEditorMode(true);
            }
        }
    }

    @Override // com.baidu.tieba.p59
    @Nullable
    public ArrayList<AtSelectData> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null && richTextEditor.getVisibility() == 0) {
                return this.t.getAtDataInText();
            }
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p59
    @Nullable
    public EditText O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null && richTextEditor.getVisibility() == 0) {
                return this.t.getLastFocusEdit();
            }
            return null;
        }
        return (EditText) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h69, com.baidu.tieba.m69
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.d();
            this.v.q(this);
        }
    }

    @Override // com.baidu.tieba.n69
    public void l() {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (richTextEditor = this.t) != null && richTextEditor.getLastFocusEdit() != null) {
            this.t.getLastFocusEdit().requestFocus();
        }
    }

    @Override // com.baidu.tieba.n69
    public void n() {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || (richTextEditor = this.t) == null) {
            return;
        }
        this.n.f(richTextEditor.getLastFocusEdit(), false);
    }

    @Override // com.baidu.tieba.n69
    public EditText p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null) {
                return richTextEditor.getLastFocusEdit();
            }
            return null;
        }
        return (EditText) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h69, com.baidu.tieba.m69
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null && !richTextEditor.u()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Y(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && str != null && this.b != null && this.t != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(str);
            writeImagesInfo.updateQuality();
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0) {
                ImageFileInfo imageFileInfo = writeImagesInfo.getChosedFiles().get(0);
                int originalImgIndex = writeImagesInfo.getOriginalImgIndex();
                this.v.g().getChosedFiles().remove(originalImgIndex);
                this.v.g().getChosedFiles().add(originalImgIndex, imageFileInfo);
                this.t.p(imageFileInfo, writeImagesInfo.getOriginalImgViewIndex());
                this.b.x(new int[]{10, 34});
            }
        }
    }

    public final void Z(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && str != null && this.b != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(str);
            writeImagesInfo.updateQuality();
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            if (chosedFiles != null) {
                for (ImageFileInfo imageFileInfo : chosedFiles) {
                    this.v.g().addChooseFile(imageFileInfo);
                    W(imageFileInfo);
                }
            }
            this.b.x(new int[]{10, 34});
            this.b.i();
        }
    }

    @Override // com.baidu.tieba.m69
    public void a(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, writeData) == null) && writeData.getWriteImagesInfo() != null) {
            this.v.r(writeData.getWriteImagesInfo());
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
    }

    @Override // com.baidu.tieba.p59, com.baidu.tieba.h69, com.baidu.tieba.m69
    public void j(@NonNull o69 o69Var) {
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, o69Var) == null) {
            super.j(o69Var);
            i69 i69Var = this.u;
            if (i69Var != null) {
                i69Var.l(this);
            }
            WriteImagesInfo g = this.v.g();
            if (g.size() > 0 && (chosedFiles = g.getChosedFiles()) != null) {
                for (ImageFileInfo imageFileInfo : chosedFiles) {
                    if (imageFileInfo != null) {
                        W(imageFileInfo);
                    }
                }
                o69 o69Var2 = this.b;
                if (o69Var2 != null) {
                    o69Var2.i();
                    this.b.x(new int[]{10, 34});
                }
            }
        }
    }

    @Override // com.baidu.tieba.p59, com.baidu.tieba.h69, com.baidu.tieba.m69
    public void m(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, bundle, intent, writeData) == null) {
            super.m(bundle, intent, writeData);
            this.v.h(bundle, intent, writeData);
        }
    }

    @Override // com.baidu.tieba.p59, com.baidu.tieba.h69, com.baidu.tieba.m69
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048599, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            this.v.m(i, i2, intent);
        }
    }

    @Override // com.baidu.tieba.m69
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04dd, viewGroup, false);
            this.c = inflate;
            this.g = inflate.findViewById(R.id.obfuscated_res_0x7f091a7e);
            this.h = (TbAlphaVideo) this.c.findViewById(R.id.obfuscated_res_0x7f090156);
            RichTextEditor richTextEditor = (RichTextEditor) this.c.findViewById(R.id.obfuscated_res_0x7f091c63);
            this.t = richTextEditor;
            richTextEditor.setWriteImagesInfo(this.v.g());
            this.t.setOutImageOperateListener(this.w);
            this.t.setOnSpanGroupChangedListener(this.p);
            this.t.setEditOnClickListener(this.o);
            this.t.setEditOnFocusChangeListener(this.s);
            this.t.setBigEmotionSpanHandler(this.q);
            this.t.k(this.r);
            WriteData writeData = this.e;
            if (writeData != null) {
                this.t.setForumId(wg.g(writeData.getForumId(), 0L));
            }
            this.t.n();
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
